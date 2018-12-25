package com.innovation.auto.module.auto.service;

import com.innovation.auto.entity.MotorInfo;

import java.util.List;

/**
 * @Auther: carver
 * @Date: 2018/12/25 09:21
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public interface AutoService {

    /**
     * 查询所有汽车信息
     * @return
     */
    List<MotorInfo> selectAuto();

}
