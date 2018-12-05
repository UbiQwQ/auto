package com.innovation.auto.entity;

import java.util.Date;

public class Comment {
    private Integer id;

    private Integer userId;

    private Integer articleId;

    private String content;

    private String agreeNum;

    private String disagreeNum;

    private Integer referenceId;

    private Date createdTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getAgreeNum() {
        return agreeNum;
    }

    public void setAgreeNum(String agreeNum) {
        this.agreeNum = agreeNum == null ? null : agreeNum.trim();
    }

    public String getDisagreeNum() {
        return disagreeNum;
    }

    public void setDisagreeNum(String disagreeNum) {
        this.disagreeNum = disagreeNum == null ? null : disagreeNum.trim();
    }

    public Integer getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Integer referenceId) {
        this.referenceId = referenceId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}