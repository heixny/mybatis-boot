package com.gec.service.it;

import com.gec.domain.InWareOrder;
import com.gec.domain.Meterial;
import com.gec.domain.OrderTask;
import com.gec.domain.PageParam;
import com.gec.service.impl.BaseService;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface ReceiptService extends BaseService<InWareOrder> {
    void commitTask( InWareOrder order);

    void refuseTask(String orderNo, Integer step);

    PageInfo<InWareOrder> getMyorderList(PageParam param, Map map);
}
