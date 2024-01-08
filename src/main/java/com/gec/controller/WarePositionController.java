package com.gec.controller;

import com.gec.domain.WarePosition;
import com.gec.domain.Workarea;
import com.gec.service.impl.BaseService;
import com.gec.service.it.WarePositionService;
import com.gec.service.it.WorkareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/WarePosition")
public class WarePositionController extends BaseController<WarePosition>{
    @Autowired
    private WarePositionService service;

    @RequestMapping("/list")
    @Override
    public Map list(@RequestBody Map map) {
        return super.list(map);
    }

    @Override
    protected BaseService<WarePosition> getService() {
        return service;
    }

    @RequestMapping("/save")
    public Map saveWarePosition(@RequestBody WarePosition pos, HttpServletRequest req){
        String id=pos.getId();
        if(id==null||id.length()==0){
            String userId = getuserId(req);
            System.out.println("{WPOS}userId:"+userId);
            pos.setInputer(userId);
        }
        try{
            service.saveWarePosition(pos);
            return sendSuccess();
        }catch(Exception e){
            e.printStackTrace();
            return sendError(e);
        }
    }
    @RequestMapping("/delete")
    public Map delWarePosition(@RequestBody Map map){
        String id= (String) map.get("id");
        try{
            service.delWarePosition(id);
            return sendSuccess();
        }catch(Exception e){
            e.printStackTrace();
            return sendError(e);
        }
    }
}
