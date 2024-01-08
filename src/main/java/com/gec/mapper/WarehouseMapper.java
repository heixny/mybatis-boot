package com.gec.mapper;

import com.gec.domain.User;
import com.gec.domain.Warehouse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface WarehouseMapper extends BaseMapper<Warehouse>{

    List<Warehouse> getList(Map map);

    int addWarehouse(Warehouse wh);

    void updateWarehouse(Warehouse wh);

    int delWarehouse(@Param("id")String id);
}
