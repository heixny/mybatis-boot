package com.gec.mapper;

import com.gec.domain.MeterialSecondary;
import com.gec.domain.MeterialType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MeterialSecondaryMapper extends BaseMapper<MeterialSecondary>{
    public int getMeterialSecondaryById();
    int addMeterialSecondary(MeterialSecondary mType);
    void updateMeterialSecondary(MeterialSecondary mType);
    int delMeterialSecondary(@Param("id")String id);
}
