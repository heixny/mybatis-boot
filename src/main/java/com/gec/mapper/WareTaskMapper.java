package com.gec.mapper;

import com.gec.domain.InWareOrder;
import com.gec.domain.InWareTask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface WareTaskMapper extends BaseMapper<InWareTask>{
    int addWareTask(InWareTask wareTask);

    int updateReceiver(@Param("orderNo") String orderNo,
                       @Param("receiverId") String receiverId,
                       @Param("step")Integer step,@Param("setTime") String setTime);

    @Override
    List<InWareTask> getList(Map map);


}
