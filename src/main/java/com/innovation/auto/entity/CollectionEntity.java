package com.innovation.auto.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CollectionEntity {
    private Integer id;

    private Integer articleId;

    private Integer userId;

    private Date createdTime;

    private String title;
}