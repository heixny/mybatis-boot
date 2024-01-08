package com.gec.controller;

import com.gec.domain.InWareOrder;
import com.gec.domain.Meterial;
import com.gec.domain.PageParam;
import com.gec.service.impl.BaseService;
import com.gec.service.it.ReceiptService;
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
@RequestMapping("/Receipt")
public class ReceiptController extends BaseController<InWareOrder>{
    @Autowired
    private ReceiptService receiptService;
    @Override
    protected BaseService<InWareOrder> getService() {
        return receiptService;
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

    @RequestMapping("/commit")
    public Map commitTask(@RequestBody InWareOrder order){
        try{
            System.out.println(order);
            if (order.getStatus().equals("已拒绝")){
                receiptService.refuseTask(order.getOrderNo(),order.getStep());
            }else{
                System.out.println("提交");
                receiptService.commitTask(order);
            }
            return sendSuccess();
        }catch(Exception e){
            e.printStackTrace();
            return sendError(e);
        }
    }
    @RequestMapping("/getMyorderList")
    public Map getMyorderList(@RequestBody Map map, HttpServletRequest req){
        String s = getuserId(req);
        map.put("inputerId",s);
        PageParam param = getPageParam(map);
        Map keywords=map;
        PageInfo<InWareOrder> pInfo= receiptService.getMyorderList(param, keywords);
        return sendData(pInfo);
    }
}
