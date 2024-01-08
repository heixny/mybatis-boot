package com.gec.mapper;

import com.gec.domain.OrderTask;
import com.gec.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TaskMapper {
    int addTask(String inwareOrderNo,String inputerId);
    void updateAssineeId(String inwareOrderNo,int step,String assigneeId);
    void updateStatus(@Param("orderNo")String orderNo, @Param("step")Integer step,
                      @Param("status")String status,@Param("setTime")String setTime);
    OrderTask getTask(@Param("orderNo")String orderNo,@Param("step")Integer step);
    int initTask(
            @Param("list") List<OrderTask> list );
}
