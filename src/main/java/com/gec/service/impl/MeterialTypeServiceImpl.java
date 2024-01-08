package com.gec.service.impl;

import com.gec.domain.MeterialType;
import com.gec.mapper.BaseMapper;
import com.gec.mapper.MeterialMapper;
import com.gec.mapper.MeterialTypeMapper;
import com.gec.service.it.MeterialTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeterialTypeServiceImpl implements MeterialTypeService {
    @Autowired(required = false)
    private MeterialTypeMapper mapper;
    @Override
    public void saveMeterialType(MeterialType meterialType) {
        String id=meterialType.getId();
        if (id!=null&&id.length()!=0){
            mapper.updateMeterialType(meterialType);
        }else{
            int ID = mapper.getMeterialTypeById();
            setMTNo(ID+1,meterialType);
            mapper.addMeterialType(meterialType);
        }
    }

    private void setMTNo(int id, MeterialType meterialType) {
        String str = String.format("%04d", id);
        String typeNo="MT"+str;
        meterialType.setTypeNo(typeNo);
    }


    @Override
    public void delMeterialType(String id) {
        if(id!=null&&id.length()!=0) {
            int c=mapper.delMeterialType(id);
        }else {
            throw new RuntimeException("删除失败");
        }
    }


    @Override
    public BaseMapper getBaseMap() {
        return mapper;
    }
}
