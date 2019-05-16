package com.innovation.auto.module.auto.service.impl;

import com.innovation.auto.entity.MotorInfo;
import com.innovation.auto.mapper.MotorInfoMapper;
import com.innovation.auto.module.auto.service.AutoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Auther: carver
 * @Date: 2018/12/25 09:21
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
@Service
public class AutoServiceImpl implements AutoService {


    @Resource
    private MotorInfoMapper motorInfoMapper;

    @Override
    public List<MotorInfo> selectAuto(Map<String,Object> map) {

        List<MotorInfo> motorInfos = motorInfoMapper.selectAuto(map);
        return motorInfos;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return motorInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MotorInfo record) {
        return motorInfoMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(MotorInfo record) {
        return motorInfoMapper.updateByPrimaryKeySelective(record);
    }

}
