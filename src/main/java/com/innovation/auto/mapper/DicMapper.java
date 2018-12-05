package com.innovation.auto.mapper;

import com.innovation.auto.entity.Dic;

public interface DicMapper {
    int deleteByPrimaryKey(Integer dicId);

    int insert(Dic record);

    int insertSelective(Dic record);

    Dic selectByPrimaryKey(Integer dicId);

    int updateByPrimaryKeySelective(Dic record);

    int updateByPrimaryKey(Dic record);
}