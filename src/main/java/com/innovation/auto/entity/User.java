package com.innovation.auto.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;

    private String name;

    private String password;

    private String birthday;

    private String randomString;

    private String gender;

    private String phone;

    private String email;

    private String personalProfile;

    private String location;

    private String experience;

    private String head;

    private Integer isAdmin;

    private Integer status;

    private Date updatedTime;

    private Date createdTime;


}