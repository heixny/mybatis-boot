package com.gec.mapper;

import com.gec.domain.Option;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OptionMapper {
    List<Option> getmtOptions();

    List<Option> getmsOptions();

    List<Option> getmgOptions();

    List<Option> getwaretypeOptions();

    List<Option> getwareOptions();

    List<Option> getareaOptions();

    List<Option> getpositionOptions();
}
