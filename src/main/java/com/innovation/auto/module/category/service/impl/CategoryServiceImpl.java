package com.innovation.auto.module.category.service.impl;

import com.innovation.auto.mapper.MotorInfoMapper;
import com.innovation.auto.module.category.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName CategoryServiceImpl
 * @Description
 * @Date 2019/5/15 20:06
 **/
@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private MotorInfoMapper motorInfoMapper;

    @Override
    public List<HashMap<String, Object>> selectByCategory() {
        return motorInfoMapper.selectByCategory();
    }
}
