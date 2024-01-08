package com.gec.controller;

import com.gec.domain.MeterialGroup;
import com.gec.domain.MeterialType;
import com.gec.service.impl.BaseService;
import com.gec.service.it.MeterialGroupService;
import com.gec.service.it.MeterialTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/MeterialGroup")
public class MeterialGroupController extends BaseController<MeterialGroup>{
    @Autowired(required = false)
    private MeterialGroupService service;
    @Override
    protected BaseService<MeterialGroup> getService() {
        return service;
    }
    @Override
    @RequestMapping("/list")
    public Map list(@RequestBody Map map) {
        return super.list(map);
    }
    @RequestMapping("/save")
    public Map saveMeterialType(@RequestBody MeterialGroup group, HttpServletRequest req){
        String id=group.getId();
        if(id==null||id.length()==0){
            String userId = getuserId(req);
            System.out.println("{MT}userId:"+userId);
            group.setInputerId(userId);
        }
        try{
            service.saveMeterialGroup(group);
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
            service.delMeterialGroup(id);
            return sendSuccess();
        }catch(Exception e){
            e.printStackTrace();
            return sendError(e);
        }
    }
}
