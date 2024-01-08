package com.gec.service.impl;

import com.gec.domain.MeterialGroup;
import com.gec.domain.MeterialType;
import com.gec.mapper.BaseMapper;
import com.gec.mapper.MeterialGroupMapper;
import com.gec.mapper.MeterialTypeMapper;
import com.gec.service.it.MeterialGroupService;
import com.gec.service.it.MeterialTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeterialGroupServiceImpl implements MeterialGroupService {
    @Autowired(required = false)
    private MeterialGroupMapper mapper;
    @Override
    public void saveMeterialGroup(MeterialGroup group) {
        String id=group.getId();
        if (id!=null&&id.length()!=0){
            mapper.updateMeterialGroup(group);
        }else{
            int ID = mapper.getMeterialGroupById();
            String gp = getno(ID + 1, 3, "gp");
            group.setGroupNo(gp);
            mapper.addMeterialGroup(group);
        }
    }


    @Override
    public void delMeterialGroup(String id) {
        if(id!=null&&id.length()!=0) {
            int c=mapper.delMeterialGroup(id);
        }else {
            throw new RuntimeException("删除失败");
        }
    }


    @Override
    public BaseMapper getBaseMap() {
        return mapper;
    }
}
