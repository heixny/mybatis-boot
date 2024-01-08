package com.gec.mapper;

import com.gec.domain.MeterialGroup;
import com.gec.domain.Warehouse;
import com.gec.domain.Workarea;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface WorkareaMapper extends BaseMapper<Workarea>{
    int getWorkareaById();
    int addWorkarea(Workarea area);
    void updateWorkarea(Workarea area);
    int delWorkarea(@Param("id")String id);
}
