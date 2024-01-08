package com.gec.controller;

import com.gec.domain.Dept;
import com.gec.domain.Meterial;
import com.gec.domain.PageParam;
import com.gec.domain.User;
import com.gec.service.impl.BaseService;
import com.gec.service.it.DeptService;
import com.gec.service.it.MeterialService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/Meterial")
public class MeterialController extends BaseController<Meterial>{
    @Autowired
    private MeterialService service;

    @Override
    @RequestMapping("/list")
    public Map list(@RequestBody Map map) {
        return super.list(map);
    }

    @RequestMapping("/saveMeterial")
    @ResponseBody
    public Map saveMeterial(@RequestBody Meterial meterial) {
        try {
            System.out.println(meterial);
            service.saveMeterial(meterial);
            return sendSuccess();
        }catch(Exception e) {
            e.printStackTrace();
            return sendError(e);
        }
    }

    @RequestMapping(value="/delMeterial")
    @ResponseBody
    public Map delMeterial(@RequestBody Map map){
        String id= (String) map.get("id");
        try {
            service.delMeterial(id);
            return sendSuccess();
        }catch(Exception e) {
            e.printStackTrace();
            return sendError(e);
        }
    }

    @RequestMapping("/getMeterialList")
    public Map getMeterialList(@RequestBody Map map){
        PageParam param = getPageParam(map);
        //未完工
        Map keywords=map;
        PageInfo<Meterial> pInfo=service.getMeterialList(param,keywords);
        return sendData(pInfo);
    }
    @Override
    protected BaseService<Meterial> getService() {
        return service;
    }
}
