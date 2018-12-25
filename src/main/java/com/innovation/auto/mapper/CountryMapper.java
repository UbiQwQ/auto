package com.innovation.auto.mapper;

import com.innovation.auto.entity.Country;

import java.util.List;

public interface CountryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Country record);

    int insertSelective(Country record);

    Country selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Country record);

    int updateByPrimaryKey(Country record);

    /**
     * 查询所有汽车厂商国家
     * @return
     */
    List<Country> selectCountry();
}