package com.gec.mapper;

import com.gec.domain.Dept;
import com.gec.domain.ProcConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProcConfigMapper extends BaseMapper<ProcConfig>{
    public List<ProcConfig> getProcByName(@Param("procName") String procName);
}
