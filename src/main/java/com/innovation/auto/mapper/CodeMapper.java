package com.innovation.auto.mapper;

import com.innovation.auto.entity.Code;

public interface CodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Code record);

    int insertSelective(Code record);

    Code selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Code record);

    int updateByPrimaryKey(Code record);
}