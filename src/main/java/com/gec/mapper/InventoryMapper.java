package com.gec.mapper;

import com.gec.domain.Inventory;
import com.gec.domain.MeterialType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InventoryMapper extends BaseMapper<Inventory>{
    int getInventoryId();
    int addInventory(Inventory inventory);
    int updateInventory(Inventory inventory);
    int delInventory(@Param("id")String id);
    Inventory getInventory(@Param("meterialNo")String meterialNo,@Param("positionNo")String positionNo);
}
