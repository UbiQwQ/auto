package com.innovation.auto.model;

/**
 * @Description:
 * @Author: vesus
 * @CreateDate: 2018/5/28 下午5:46
 * @Version: 1.0
 */
public class HelloMessage {

    /***
     * 请求消息
     */
    private String name;

    public HelloMessage() {
    }

    public HelloMessage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
