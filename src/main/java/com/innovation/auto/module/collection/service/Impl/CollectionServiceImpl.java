package com.innovation.auto.module.collection.service.Impl;

import com.innovation.auto.entity.CollectionEntity;
import com.innovation.auto.mapper.CollectionMapper;
import com.innovation.auto.module.collection.service.CollectionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: carver
 * @Date: 2019/1/6 23:25
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
@Service
public class CollectionServiceImpl implements CollectionService {

    @Resource
    private CollectionMapper collectionMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        int resule = collectionMapper.deleteByPrimaryKey(id);
        return resule;
    }

    @Override
    public List<CollectionEntity> selectMyCollection(CollectionEntity collection) {
        List<CollectionEntity> collections = collectionMapper.selectMyCollection(collection);
        return collections;
    }
}
