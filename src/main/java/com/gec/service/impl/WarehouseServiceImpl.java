package com.gec.service.impl;

import com.gec.domain.Warehouse;
import com.gec.mapper.BaseMapper;
import com.gec.mapper.WarehouseMapper;
import com.gec.service.it.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired(required = false)
    private WarehouseMapper mapper;

    @Override
    public BaseMapper getBaseMap() {
        return mapper;
    }


    @Override
    public void saveWarehouse(Warehouse warehouse) {
        String id=warehouse.getId();
//        System.out.println("id:"+id+",length:"+id.length());
        if(id!=null&&id.length()!=0) {
            mapper.updateWarehouse(warehouse);
        }else {
            int c=mapper.addWarehouse(warehouse);
        }
    }

    @Override
    public void delWarehouse(String id) {
        if(id!=null) {
            int c=mapper.delWarehouse(id);
        }else {
            throw new RuntimeException();
        }
    }
}
