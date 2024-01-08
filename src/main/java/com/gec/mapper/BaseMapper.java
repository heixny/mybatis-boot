package com.gec.mapper;

import java.util.List;
import java.util.Map;

public interface BaseMapper<T> {
    List<T> getList(Map map);
}
