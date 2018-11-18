package com.innovation.auto.mapper;


import com.innovation.auto.entity.Manufacturer;
import com.innovation.auto.entity.ManufacturerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManufacturerMapper {
    int countByExample(ManufacturerExample example);

    int deleteByExample(ManufacturerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Manufacturer record);

    int insertSelective(Manufacturer record);

    List<Manufacturer> selectByExampleWithBLOBs(ManufacturerExample example);

    List<Manufacturer> selectByExample(ManufacturerExample example);

    Manufacturer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Manufacturer record, @Param("example") ManufacturerExample example);

    int updateByExampleWithBLOBs(@Param("record") Manufacturer record, @Param("example") ManufacturerExample example);

    int updateByExample(@Param("record") Manufacturer record, @Param("example") ManufacturerExample example);

    int updateByPrimaryKeySelective(Manufacturer record);

    int updateByPrimaryKeyWithBLOBs(Manufacturer record);

    int updateByPrimaryKey(Manufacturer record);
}