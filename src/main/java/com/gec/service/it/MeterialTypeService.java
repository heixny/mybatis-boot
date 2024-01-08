package com.gec.service.it;

import com.gec.domain.Dept;
import com.gec.domain.MeterialType;
import com.gec.service.impl.BaseService;

public interface MeterialTypeService extends BaseService<MeterialType> {
    void saveMeterialType(MeterialType meterialType);

    void delMeterialType(String id);

}
