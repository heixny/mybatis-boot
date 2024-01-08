package com.gec.mapper;

import com.gec.domain.MeterialGroup;
import com.gec.domain.MeterialType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MeterialGroupMapper extends BaseMapper<MeterialGroup>{
    public int getMeterialGroupById();
    int addMeterialGroup(MeterialGroup group);
    void updateMeterialGroup(MeterialGroup group);
    int delMeterialGroup(@Param("id")String id);
}
