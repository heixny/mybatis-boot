package com.gec.mapper;

import com.gec.domain.InWareDetail;
import com.gec.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DetailMapper extends BaseMapper<InWareDetail> {
    @Override
    List<InWareDetail> getList(Map map);

    int addDetail(InWareDetail detail);

    void updateDetail(InWareDetail detail);
    int delDetail(@Param("id")String id);

    List<InWareDetail> getDetail(@Param("orderNo") String orderNo);
}
