package com.yunlong.softpark.dto;

import lombok.Data;

/**
 * @Author 王海澎
 * @Date 2020/7/28 16:40
 * @Version 1.0
 */
@Data
public class RankDto{

    /**
     * 栏目名
     */
    private String columnName;

    /**
     * 栏目logo
     */
    private String columnLogo;

    /**
     * 栏目下载量
     */
    private int downloads;

}
