package com.innovation.auto.mapper;

import com.innovation.auto.entity.CollectionEntity;

public interface CollectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CollectionEntity record);

    int insertSelective(CollectionEntity record);

    CollectionEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CollectionEntity record);

    int updateByPrimaryKey(CollectionEntity record);
}