package com.gec.service.it;

import com.gec.domain.Meterial;
import com.gec.domain.Warehouse;
import com.gec.service.impl.BaseService;

public interface WarehouseService extends BaseService<Warehouse> {
    void saveWarehouse(Warehouse warehouse);

    void delWarehouse(String id);
}
