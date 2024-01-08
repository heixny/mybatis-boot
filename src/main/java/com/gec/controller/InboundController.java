package com.gec.controller;

import com.gec.domain.InWareTask;
import com.gec.domain.PageParam;
import com.gec.domain.TaskDetail;
import com.gec.service.impl.BaseService;
import com.gec.service.it.InboundService;
import com.gec.utils.JwtUtils;
import com.github.pagehelper.PageInfo;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/Inbound")
public class InboundController extends BaseController<InWareTask>{
    @Autowired
    private InboundService inboundService;

    @Override
    protected BaseService<InWareTask> getService() {
        return inboundService;
    }

    @RequestMapping("/list")
    public Map list(@RequestBody Map map, HttpServletRequest req) {
        String token = req.getHeader("token");
        //解析JwtToken
        Claims claims= JwtUtils.parseJWT(token);
        //获取userId
        String userId = (String) claims.get("userId");
        System.out.println("userId:"+userId);
        map.put("receiverId",userId);
        return super.list(map);
    }
    @RequestMapping("/getTaskDetaillist")
    public Map getTaskDetaillist(@RequestBody Map map){
        PageParam param = getPageParam(map);
        //未完工
        Map keywords=map;
        PageInfo<TaskDetail> pInfo=inboundService.getTaskDetailList(param,keywords);
        return sendData(pInfo);
    }
    @RequestMapping("/commitTask")
    public Map commitTask(@RequestBody InWareTask wareTask){
        try{
            inboundService.commitTask(wareTask);
            return sendSuccess();
        }catch(Exception e){
            e.printStackTrace();
            return sendError(e);
        }
    }

}
