package com.gec.service.impl;

import com.gec.domain.Dept;
import com.gec.domain.PageParam;
import com.gec.mapper.BaseMapper;
import com.gec.mapper.DeptMapper;
import com.gec.service.it.DeptService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired(required = false)
    private DeptMapper mapper;

    @Override
    public BaseMapper getBaseMap() {
        return mapper;
    }

}
