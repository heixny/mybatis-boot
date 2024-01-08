package com.gec.controller;

import com.gec.domain.InWareDetail;
import com.gec.domain.InWareOrder;
import com.gec.domain.User;
import com.gec.mapper.UserMapper;
import com.gec.service.impl.BaseService;
import com.gec.service.it.DetailService;
import com.gec.service.it.RequestService;
import com.gec.service.it.UserService;
import com.gec.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/Request")
public class RequestController extends BaseController<InWareDetail>{
    @Autowired
    private DetailService detailService;
    @Autowired
    private RequestService requestService;
    @Autowired
    private UserService userService;
    @RequestMapping("/list")
    @Override
    public Map list(@RequestBody Map map) {
        return super.list(map);
    }

    @RequestMapping("/saveDetail")
    public Map saveDetail(@RequestBody InWareDetail detail) {
        try {
            System.out.println("{detail}detail:"+detail);
            detailService.saveDetail(detail);
            return sendSuccess();
        }catch(Exception e) {
            e.printStackTrace();
            return sendError(e);
        }
    }
    @RequestMapping("/startProc")
    public Map startProc(@RequestBody InWareOrder order){

        try{
            requestService.startproc(order,"入库申请流程");
            return sendSuccess();
        }catch(Exception e){
            e.printStackTrace();
            return sendError(e);
        }
    }
    @RequestMapping("/getUser")
    public Map getUser(HttpServletRequest req){
        String token = req.getHeader("token");
        //解析JwtToken
        Claims claims= JwtUtils.parseJWT(token);
        //获取userId
        String userId = (String) claims.get("userId");
        System.out.println("userId:"+userId);
        try{
            User user=userService.getUserById(userId);
            return sendData(user);
        }catch(Exception e){
            e.printStackTrace();
            return sendError(e);
        }
    }
    @RequestMapping("/delDetail")
    public Map delDetail(@RequestBody Map map){
        String id = (String) map.get("id");
        try{
            System.out.println("{detail}id:"+id);
            detailService.delDetail(id);
            return sendSuccess();
        }catch(Exception e){
            e.printStackTrace();
            return sendError(e);
        }
    }

    @Override
    protected BaseService<InWareDetail> getService() {
        return detailService;
    }
}
