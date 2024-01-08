package com.gec.service.impl;

import com.gec.domain.Workarea;
import com.gec.mapper.BaseMapper;
import com.gec.mapper.WarehouseMapper;
import com.gec.mapper.WorkareaMapper;
import com.gec.service.it.WarehouseService;
import com.gec.service.it.WorkareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkareaServiceImpl implements WorkareaService {
    @Autowired(required = false)
    private WorkareaMapper mapper;

    @Override
    public BaseMapper getBaseMap() {
        return mapper;
    }

    @Override
    public void saveWorkarea(Workarea area) {
        String id=area.getId();
        if (id!=null&&id.length()!=0){
            mapper.updateWorkarea(area);
        }else{
            int ID = mapper.getWorkareaById();
            String gp = getno(ID + 1, 3, "WA");
            area.setAreaNo(gp);
            mapper.addWorkarea(area);
        }
    }

    @Override
    public void delWorkarea(String id) {
        if(id!=null&&id.length()!=0) {
            int c=mapper.delWorkarea(id);
        }else {
            throw new RuntimeException("删除失败");
        }
    }
}
