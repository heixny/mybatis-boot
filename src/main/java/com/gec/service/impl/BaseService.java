package com.gec.service.impl;

import com.gec.domain.Dept;
import com.gec.domain.PageParam;
import com.gec.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface BaseService<T> {
    BaseMapper getBaseMap();
    default PageInfo<T> getPageList(PageParam param, Map map) {
        System.out.println("+------getList------+");
        System.out.println(map.get("service:userName:"));
        System.out.println("+-------------------+");
        BaseMapper mapper=getBaseMap();
        Page<T> page= PageHelper.startPage(param.getPage(),param.getLimit(),true);
        List<T> list=mapper.getList(map);
        PageInfo info = new PageInfo(list);
        info.setTotal(page.getTotal());
        return info;
    }
    default String createUUID(int len){
        String uuid = UUID.randomUUID().toString();
        return uuid.replace("-", "").substring(0, len);
    }
    //id=目前最大id+1,n为数字个数，pre为前缀
    default String getno(int id,int n,String pre){
        String str = String.format("%0"+n+"d", id);
        String No=pre+str;
        System.out.println("{BaseService}no:"+No);
        return No;
    }
}
