package com.yunlong.softpark.dto;

import lombok.Data;

/**
 * @Author 王海澎
 * @Date 2020/7/28 21:41
 * @Version 1.0
 */
@Data
public class ColumnDetailDto {

    /**
     * 栏目简介
     */
    private String briefIntro;

    /**
     * 栏目功能
     */
    private String function;

    /**
     * 栏目特色
     */
    private String character;

    /**
     * 下载地址
     */
    private String installAddr;
}
