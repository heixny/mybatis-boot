package com.gec.controller;

import com.gec.domain.MeterialType;
import com.gec.service.impl.BaseService;
import com.gec.service.it.MeterialTypeService;
import com.gec.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/MeterialType")
public class MeterialTypeController extends BaseController<MeterialType>{
    @Autowired(required = false)
    private MeterialTypeService service;
    @Override
    protected BaseService<MeterialType> getService() {
        return service;
    }
    @Override
    @RequestMapping("/list")
    public Map list(@RequestBody Map map) {
        return super.list(map);
    }
    @RequestMapping("/save")
    public Map saveMeterialType(@RequestBody MeterialType meterialType, HttpServletRequest req){
        String id=meterialType.getId();
        if(id==null||id.length()==0){
            String userId = getuserId(req);
            System.out.println("{MT}userId:"+userId);
            meterialType.setInputerId(userId);
        }
        try{
            service.saveMeterialType(meterialType);
            return sendSuccess();
        }catch(Exception e){
            e.printStackTrace();
            return sendError(e);
        }
    }
    @RequestMapping("/delete")
    public Map delMeterialType(@RequestBody Map map){
        String id= (String) map.get("id");
        try{
            service.delMeterialType(id);
            return sendSuccess();
        }catch(Exception e){
            e.printStackTrace();
            return sendError(e);
        }
    }
}
