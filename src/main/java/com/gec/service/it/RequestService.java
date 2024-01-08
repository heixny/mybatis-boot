package com.gec.service.it;

import com.gec.domain.InWareDetail;
import com.gec.domain.InWareOrder;
import com.gec.domain.User;
import com.gec.service.impl.BaseService;

public interface RequestService{
    //security弄玩，添加入参User
    void startproc(InWareOrder order,String procName);

    void commitTask( String orderNo, Integer step);
}
