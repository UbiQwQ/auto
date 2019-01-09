package com.innovation.auto.mapper;

import com.innovation.auto.entity.CollectionEntity;

import java.util.List;

public interface CollectionMapper {

    /**
     * 根据collectionID删除收藏
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    int insert(CollectionEntity record);

    int insertSelective(CollectionEntity record);

    CollectionEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CollectionEntity record);

    int updateByPrimaryKey(CollectionEntity record);

    /**
     * 根据用户id查询收藏
     * @param collection
     * @return
     */
    List<CollectionEntity> selectMyCollection(CollectionEntity collection);

    /**
     * 查询该条收藏
     * @param collection
     * @return
     */
    CollectionEntity selectCancelCollection(CollectionEntity collection);
}