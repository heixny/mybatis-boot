package com.gec.controller;

import com.gec.domain.MeterialSecondary;
import com.gec.domain.MeterialType;
import com.gec.service.impl.BaseService;
import com.gec.service.it.MeterialSecondaryService;
import com.gec.service.it.MeterialTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/MeterialSecondary")
public class MeterialSecondaryController extends BaseController<MeterialSecondary>{
    @Autowired(required = false)
    private MeterialSecondaryService service;
    @Override
    protected BaseService<MeterialSecondary> getService() {
        return service;
    }
    @Override
    @RequestMapping("/list")
    public Map list(@RequestBody Map map) {
        return super.list(map);
    }
    @RequestMapping("/save")
    public Map save(@RequestBody MeterialSecondary ms, HttpServletRequest req){
        String id=ms.getId();
        if(id==null||id.length()==0){
            String userId = getuserId(req);
            System.out.println("{MT}userId:"+userId);
            ms.setInputerId(userId);
        }
        try{
            service.saveMeterialSecondary(ms);
            return sendSuccess();
        }catch(Exception e){
            e.printStackTrace();
            return sendError(e);
        }
    }
    @RequestMapping("/delete")
    public Map delete(@RequestBody Map map){
        String id= (String) map.get("id");
        try{
            service.delMeterialSecondary(id);
            return sendSuccess();
        }catch(Exception e){
            e.printStackTrace();
            return sendError(e);
        }
    }
}
