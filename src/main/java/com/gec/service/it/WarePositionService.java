package com.gec.service.it;

import com.gec.domain.WarePosition;
import com.gec.domain.Workarea;
import com.gec.service.impl.BaseService;

public interface WarePositionService extends BaseService<WarePosition> {
    void saveWarePosition(WarePosition pos);

    void delWarePosition(String id);
}
