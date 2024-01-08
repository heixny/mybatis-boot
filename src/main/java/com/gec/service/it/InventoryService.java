package com.gec.service.it;

import com.gec.domain.Inventory;
import com.gec.domain.MeterialGroup;
import com.gec.service.impl.BaseService;

public interface InventoryService extends BaseService<Inventory> {
    void saveInventory(Inventory inventory);

    void delInventory(String id);

}
