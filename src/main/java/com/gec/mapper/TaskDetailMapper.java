package com.gec.mapper;

import com.gec.domain.InWareDetail;
import com.gec.domain.TaskDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;
import java.util.Map;

@Mapper
public interface TaskDetailMapper extends BaseMapper<TaskDetail> {
    @Override
    List<TaskDetail> getList(Map map);

    int addTaskDetail(TaskDetail taskDetail);

    int updateStatus(@Param("orderNo") String orderNo,@Param("status") String status);
}
