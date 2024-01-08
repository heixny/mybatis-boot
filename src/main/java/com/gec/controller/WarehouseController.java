package com.gec.controller;

import com.gec.domain.Meterial;
import com.gec.domain.Warehouse;
import com.gec.service.impl.BaseService;
import com.gec.service.it.WarehouseService;
import com.gec.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Warehouse")
public class WarehouseController extends BaseController<Warehouse>{
    @Autowired
    private WarehouseService service;

    @RequestMapping("/list")
    @Override
    public Map list(@RequestBody Map map) {
        return super.list(map);
    }

    @Override
    protected BaseService<Warehouse> getService() {
        return service;
    }


    @RequestMapping("/saveWarehouse")
    public Map saveWarehouse(@RequestBody Warehouse warehouse) {
        try {
            System.out.println(warehouse);
            service.saveWarehouse(warehouse);
            return sendSuccess();
        }catch(Exception e) {
            e.printStackTrace();
            return sendError(e);
        }
    }
    @RequestMapping("/delWarehouse")
    public Map delWarehouse(@RequestBody Map map){
        String id= (String) map.get("id");
        try {
            service.delWarehouse(id);
            return sendSuccess();
        }catch(Exception e) {
            e.printStackTrace();
            return sendError(e);
        }
    }
    @RequestMapping("/getUserId")
    public Map getUserId(HttpServletRequest req){
        String token = req.getHeader("token");
        //解析JwtToken
        Claims claims= JwtUtils.parseJWT(token);
        //获取userId
        String userId = (String) claims.get("userId");
        Map map=new HashMap();
        map.put("userId",userId);
        return map;
    }

}
