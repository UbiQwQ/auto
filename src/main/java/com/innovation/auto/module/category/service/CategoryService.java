package com.innovation.auto.module.category.service;

import java.util.HashMap;
import java.util.List;

/**
 * @Description
 * @Author liyuhao
 * @Date 2019/5/15 20:05
 **/
public interface CategoryService {

    /*
     * @Description 分类查看机车信息
     * @Date 2019/5/15 23:02
     * @Param []
     * @Return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     **/
    List<HashMap<String,Object>> selectByCategory();
}
