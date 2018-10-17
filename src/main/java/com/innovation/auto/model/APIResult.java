package com.innovation.auto.model;

import lombok.Data;

/**
 * @Auther: carver
 * @Date: 2018/10/17 08:47
 * @email lt1550919167@163.com qq:1550919167
 * @Description:
 */
@Data
public class APIResult {

    private String msg ;
    private int status;
    private Object res = null;

}
