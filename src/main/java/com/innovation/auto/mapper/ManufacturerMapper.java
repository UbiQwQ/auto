package com.innovation.auto.mapper;

import com.innovation.auto.entity.Manufacturer;

public interface ManufacturerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Manufacturer record);

    int insertSelective(Manufacturer record);

    Manufacturer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Manufacturer record);

    int updateByPrimaryKeyWithBLOBs(Manufacturer record);

    int updateByPrimaryKey(Manufacturer record);
}