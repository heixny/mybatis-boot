package com.gec.service.impl;

import com.gec.domain.MeterialSecondary;
import com.gec.mapper.BaseMapper;
import com.gec.mapper.MeterialSecondaryMapper;
import com.gec.service.it.MeterialSecondaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeterialSecondaryServiceImpl implements MeterialSecondaryService {
    @Autowired(required = false)
    private MeterialSecondaryMapper mapper;
    @Override
    public void saveMeterialSecondary(MeterialSecondary ms) {
        String id=ms.getId();
        if (id!=null&&id.length()!=0){
            mapper.updateMeterialSecondary(ms);
        }else{
            int ID = mapper.getMeterialSecondaryById();
//            setMTNo(ID+1,meterialType);
            String no = getno(ID+1, 4, "MS");
            ms.setSecondaryNo(no);
            mapper.addMeterialSecondary(ms);
        }
    }

    @Override
    public void delMeterialSecondary(String id) {
        if(id!=null&&id.length()!=0) {
            int c=mapper.delMeterialSecondary(id);
        }else {
            throw new RuntimeException("删除失败");
        }
    }

    @Override
    public BaseMapper getBaseMap() {
        return mapper;
    }
}
