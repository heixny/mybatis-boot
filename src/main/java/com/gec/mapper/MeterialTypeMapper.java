package com.gec.mapper;

import com.gec.domain.Dept;
import com.gec.domain.MeterialType;
import com.gec.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MeterialTypeMapper extends BaseMapper<MeterialType>{
    public int getMeterialTypeById();
    int addMeterialType(MeterialType mType);
    void updateMeterialType(MeterialType mType);
    int delMeterialType(@Param("id")String id);
}
