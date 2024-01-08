package com.gec.mapper;

import com.gec.domain.WarePosition;
import com.gec.domain.Workarea;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WarePositionMapper extends BaseMapper<WarePosition>{
    int getWarePositionById();
    int addWarePosition(WarePosition pos);
    void updateWarePosition(WarePosition pos);
    int delWarePosition(@Param("id")String id);
}
