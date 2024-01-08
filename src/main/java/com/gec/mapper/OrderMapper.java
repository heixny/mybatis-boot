package com.gec.mapper;

import com.gec.domain.InWareOrder;
import com.gec.domain.Meterial;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper extends BaseMapper<InWareOrder>{
    int addOrder(InWareOrder order);

    int updateReceiver(@Param("orderNo") String orderNo,
                        @Param("receiverId") String receiverId,
                        @Param("step")Integer step,@Param("setTime") String setTime);
    List<InWareOrder> getList(Map map);

    List<InWareOrder> getMyorderList(Map map);
}
