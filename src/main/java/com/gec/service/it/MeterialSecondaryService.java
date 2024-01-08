package com.gec.service.it;

import com.gec.domain.MeterialSecondary;
import com.gec.domain.MeterialType;
import com.gec.service.impl.BaseService;

public interface MeterialSecondaryService extends BaseService<MeterialSecondary> {
    void saveMeterialSecondary(MeterialSecondary ms);

    void delMeterialSecondary(String id);

}
