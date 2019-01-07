package com.innovation.auto.module.collection.service;

import com.innovation.auto.entity.CollectionEntity;

import java.util.List;

/**
 * @Auther: carver
 * @Date: 2019/1/6 23:25
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public interface CollectionService {

    /**
     * 根据collectionID删除收藏
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 根据用户id查询收藏
     * @param collection
     * @return
     */
    List<CollectionEntity> selectMyCollection(CollectionEntity collection);
}
