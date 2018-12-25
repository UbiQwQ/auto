package com.innovation.auto.module.country.service;

import com.innovation.auto.entity.Country;

import java.util.List;

/**
 * @Auther: carver
 * @Date: 2018/12/24 22:04
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public interface CountryService {

    /**
     * 查询所有汽车厂商国家
     * @return
     */
    List<Country> selectCountry();
}
