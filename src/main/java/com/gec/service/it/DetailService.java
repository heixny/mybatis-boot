package com.gec.service.it;

import com.gec.domain.InWareDetail;
import com.gec.domain.Meterial;
import com.gec.service.impl.BaseService;

public interface DetailService extends BaseService<InWareDetail> {
    void saveDetail(InWareDetail detail);

    void delDetail(String id);
}
