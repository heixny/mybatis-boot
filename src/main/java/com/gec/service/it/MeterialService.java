package com.gec.service.it;

import com.gec.domain.Dept;
import com.gec.domain.Meterial;
import com.gec.domain.PageParam;
import com.gec.domain.User;
import com.gec.mapper.BaseMapper;
import com.gec.service.impl.BaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface MeterialService extends BaseService<Meterial> {
    void saveMeterial(Meterial meterial);

    void delMeterial(String id);

    PageInfo<Meterial> getMeterialList(PageParam param, Map map);
}
