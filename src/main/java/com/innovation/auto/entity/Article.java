package com.innovation.auto.entity;

import java.util.Date;

public class Article {
    private Integer id;

    private Integer userId;

    private String title;

    private Date createdTime;

    private String agreeNum;

    private String disagreeNum;

    private String clicks;

    private String customTags;

    private Integer classificationId;

    private String image;

    private String textBody;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
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

    public String getClicks() {
        return clicks;
    }

    public void setClicks(String clicks) {
        this.clicks = clicks == null ? null : clicks.trim();
    }

    public String getCustomTags() {
        return customTags;
    }

    public void setCustomTags(String customTags) {
        this.customTags = customTags == null ? null : customTags.trim();
    }

    public Integer getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Integer classificationId) {
        this.classificationId = classificationId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getTextBody() {
        return textBody;
    }

    public void setTextBody(String textBody) {
        this.textBody = textBody == null ? null : textBody.trim();
    }
}