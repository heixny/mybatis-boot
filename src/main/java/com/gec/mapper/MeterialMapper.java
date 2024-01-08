package com.gec.mapper;

import com.gec.domain.Meterial;
import com.gec.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MeterialMapper extends BaseMapper<Meterial>{
    List<Meterial> getList(Map map);

    void updateMeterial(Meterial meterial);

    int addMeterial(Meterial meterial);

    int getlastIndex();

    int delMeterial(@Param("id")String id);

    List<Meterial> getMeterialList(Map map);
}
