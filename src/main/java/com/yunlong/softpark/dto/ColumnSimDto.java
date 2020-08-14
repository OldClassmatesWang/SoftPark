package com.yunlong.softpark.dto;

import lombok.Data;

/**
 * @Author 王海澎
 * @Date 2020/7/28 20:58
 * @Version 1.0
 */
@Data
public class ColumnSimDto {
    /**
     * 栏目名
     * 栏目logo
     * 栏目官网
     * 官方介绍
     * 授权信息
     * 下载次数
     * 页面展示
     */

    /**
     * 栏目名
     */
    private String columnName;

    /**
     * 栏目logo
     */
    private String columnLogo;

    /**
     * 栏目官网
     */
    private String columnWeb;

    /**
     * 官方介绍
     */
    private String webIntroduce;

    /**
     * 授权信息
     */
    private String license;

    /**
     * 下载次数
     */
    private int downloads;

    /**
     * 页面展示
     */
    private String showPic;

    /**
     * 软件类型
     */
    private String columnType;

}
