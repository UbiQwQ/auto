package com.innovation.auto.module.country.service.impl;

import com.innovation.auto.module.country.service.CountryService;
import com.innovation.auto.entity.Country;
import com.innovation.auto.mapper.CountryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: carver
 * @Date: 2018/12/24 22:05
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
@Service
public class CountryServiceImpl implements CountryService {
    
    @Resource
    private CountryMapper countryMapper;

    /**
     * 查询所有厂商国家
     * @return
     */
    @Override
    public List<Country> selectCountry() {
        List<Country> countryList = countryMapper.selectCountry();
        return countryList;
    }

    
}
