package com.gec.mapper;

import com.gec.domain.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DeptMapper extends BaseMapper<Dept>{
    public Dept getDeptById(String id);
    List<Dept> getList(Map map);
}
