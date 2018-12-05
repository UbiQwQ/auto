package com.innovation.auto.mapper;

import com.innovation.auto.entity.AppAccessLog;

public interface AppAccessLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppAccessLog record);

    int insertSelective(AppAccessLog record);

    AppAccessLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppAccessLog record);

    int updateByPrimaryKeyWithBLOBs(AppAccessLog record);

    int updateByPrimaryKey(AppAccessLog record);
}