package com.yunlong.softpark.entity;

import lombok.Data;

/**
 * @Author: Cui
 * @Date: 2020/7/23
 * @Description:
 */
@Data
public class UserEntity {

    private String username;

    private String userId;

    private String phone;

    private String email;

    private String password;

    private String createTime;

    private String updateTime;
}
