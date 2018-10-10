package com.innovation.auto.model;

/**
 * @Description:
 * @Author: vesus
 * @CreateDate: 2018/5/28 下午5:47
 * @Version: 1.0
 */
public class Greeting {

    /**
     * 响应消息
     */
    private String content;

    public Greeting() {
    }

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
