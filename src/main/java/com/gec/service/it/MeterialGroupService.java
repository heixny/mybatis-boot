package com.gec.service.it;

import com.gec.domain.MeterialGroup;
import com.gec.domain.MeterialType;
import com.gec.service.impl.BaseService;

public interface MeterialGroupService extends BaseService<MeterialGroup> {
    void saveMeterialGroup(MeterialGroup group);

    void delMeterialGroup(String id);

}
