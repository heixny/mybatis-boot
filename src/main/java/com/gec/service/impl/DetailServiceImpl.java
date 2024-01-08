package com.gec.service.impl;

import com.gec.domain.InWareDetail;
import com.gec.mapper.BaseMapper;
import com.gec.mapper.DetailMapper;
import com.gec.service.it.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailServiceImpl implements DetailService {
    @Autowired(required = false)
    private DetailMapper mapper;

    @Override
    public void saveDetail(InWareDetail detail) {
        String id=detail.getId();
        int c=0;
        if (id!=null&&id.length()!=0){
            mapper.updateDetail(detail);
        }else{
            c=mapper.addDetail(detail);
        }
        if (c!=1){
            throw new RuntimeException("添加失败");
        }
    }

    @Override
    public void delDetail(String id) {
        if(id!=null&&id.length()!=0) {
            int c=mapper.delDetail(id);
        }else {
            throw new RuntimeException("删除失败");
        }
    }

    @Override
    public BaseMapper getBaseMap() {
        return mapper;
    }
}
