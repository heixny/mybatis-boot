package com.gec.service.impl;

import com.gec.domain.Inventory;
import com.gec.domain.MeterialGroup;
import com.gec.mapper.BaseMapper;
import com.gec.mapper.InventoryMapper;
import com.gec.mapper.MeterialGroupMapper;
import com.gec.service.it.InventoryService;
import com.gec.service.it.MeterialGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired(required = false)
    private InventoryMapper mapper;
    @Override
    public void saveInventory(Inventory inventory) {
        String meterialNo = inventory.getMeterialNo();
        Inventory ity = mapper.getInventory(meterialNo, inventory.getPositionNo());
        if (ity!=null){
            Integer count = ity.getCount();
            ity.setCount(count+inventory.getCount());
//            System.err.println(ity);
            int i=mapper.updateInventory(ity);
        }else{
            int ID = mapper.getInventoryId();
            String gp = getno(ID + 1, 5, "ITY");
            inventory.setInventoryNo(gp);
            System.err.println(inventory);
            mapper.addInventory(inventory);
        }
    }


    @Override
    public void delInventory(String id) {
        if(id!=null&&id.length()!=0) {
            int c=mapper.delInventory(id);
        }else {
            throw new RuntimeException("删除失败");
        }
    }


    @Override
    public BaseMapper getBaseMap() {
        return mapper;
    }
}
