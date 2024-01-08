package com.gec.service.it;

import com.gec.domain.InWareOrder;
import com.gec.domain.InWareTask;
import com.gec.domain.PageParam;
import com.gec.domain.TaskDetail;
import com.gec.service.impl.BaseService;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface InboundService extends BaseService<InWareTask> {
    PageInfo<TaskDetail> getTaskDetailList(PageParam param, Map map);

    void commitTask(InWareTask order);
}
