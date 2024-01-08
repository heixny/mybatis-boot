package com.gec.service.it;

import com.gec.domain.MeterialGroup;
import com.gec.domain.Warehouse;
import com.gec.domain.Workarea;
import com.gec.service.impl.BaseService;

public interface WorkareaService extends BaseService<Workarea> {
    void saveWorkarea(Workarea area);

    void delWorkarea(String id);
}
