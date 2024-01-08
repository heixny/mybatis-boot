package com.gec.controller;

import com.gec.domain.MeterialGroup;
import com.gec.domain.Warehouse;
import com.gec.domain.Workarea;
import com.gec.service.impl.BaseService;
import com.gec.service.it.WarehouseService;
import com.gec.service.it.WorkareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/Workarea")
public class WorkareaController extends BaseController<Workarea>{
    @Autowired
    private WorkareaService service;

    @RequestMapping("/list")
    @Override
    public Map list(@RequestBody Map map) {
        return super.list(map);
    }

    @Override
    protected BaseService<Workarea> getService() {
        return service;
    }

    @RequestMapping("/save")
    public Map saveWorkarea(@RequestBody Workarea area, HttpServletRequest req){
        String id=area.getId();
        if(id==null||id.length()==0){
            String userId = getuserId(req);
            System.out.println("{WA}userId:"+userId);
            area.setInputer(userId);
        }
        try{
            service.saveWorkarea(area);
            return sendSuccess();
        }catch(Exception e){
            e.printStackTrace();
            return sendError(e);
        }
    }
    @RequestMapping("/delete")
    public Map delWorkarea(@RequestBody Map map){
        String id= (String) map.get("id");
        try{
            service.delWorkarea(id);
            return sendSuccess();
        }catch(Exception e){
            e.printStackTrace();
            return sendError(e);
        }
    }
}
