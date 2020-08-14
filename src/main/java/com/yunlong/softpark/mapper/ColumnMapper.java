package com.yunlong.softpark.mapper;

import com.yunlong.softpark.dto.ColumnSimDto;
import com.yunlong.softpark.dto.RankDto;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author 王海澎
 * @Date 2020/7/28 16:54
 * @Version 1.0
 */

@Repository
public interface ColumnMapper {

    /**
     * 搜索出栏目名，栏目logo，栏目下载量三个属性
     * @return
     */
    @Select("select \"COLUMN_NAME\",\"COLUMN_LOGO\",\"DOWNLOADS\"\n" +
            "from \"softpark\".\"COLUMN\";\n")
    List<RankDto> selectDataForRank();

    /**
     * * 搜索出
     *      * 栏目名
     *      * 栏目logo
     *      * 栏目官网
     *      * 官方介绍
     *      * 授权信息
     *      * 下载次数
     *      * 页面展示
     * @param columnId
     * @return
     */
    @Select("select \"COLUMN_NAME\",\"COLUMN_LOGO\",\"COLUMN_WEB\",\"WEB_INTRODUCE\",\"LICENSE\",\"SHOW_PIC\",\"DOWNLOADS\",\"COLUMN_TYPE\"\n" +
            "from \"softpark\".\"COLUMN\" where \"COLUMN_ID\"=#{columnId};\n")
    ColumnSimDto selectDataForSimpleColumn(String columnId);

    /**
     * 根据columnId搜索出introduceId
     * @param columnId
     * @return
     */
    @Select("select \"INTRODUCE_ID\"\n" +
            "from \"softpark\".\"COLUMN\" where \"COLUMN_ID\" = #{columnId};")
    String selectIntroducIdBycolumnId(String columnId);

    /**
     * 根据columnId搜索出官网地址
     * @param columnId
     */
    @Select("select \"COLUMN_WEB\"\n" +
            "from \"softpark\".\"COLUMN\" where \"COLUMN_ID\"=#{columnId};\n" +
            "\n")
    String selectDataForBaseData(String columnId);
}
