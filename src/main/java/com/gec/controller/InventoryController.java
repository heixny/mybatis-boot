package com.gec.controller;

import com.gec.domain.Inventory;
import com.gec.domain.MeterialGroup;
import com.gec.service.impl.BaseService;
import com.gec.service.it.InventoryService;
import com.gec.service.it.MeterialGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/Inventory")
public class InventoryController extends BaseController<Inventory>{
    @Autowired(required = false)
    private InventoryService service;
    @Override
    protected BaseService<Inventory> getService() {
        return service;
    }
    @Override
    @RequestMapping("/list")
    public Map list(@RequestBody Map map) {
        return super.list(map);
    }
    @RequestMapping("/save")
    public Map saveMeterialType(@RequestBody Inventory inventory, HttpServletRequest req){
        try{
            service.saveInventory(inventory);
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
            service.delInventory(id);
            return sendSuccess();
        }catch(Exception e){
            e.printStackTrace();
            return sendError(e);
        }
    }
}
