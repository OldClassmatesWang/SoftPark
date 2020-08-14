package com.yunlong.softpark.mapper;

import com.yunlong.softpark.entity.SoftwareEntity;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoftwareMapper {

    /**
     * 通过userId获取历史发布的软件信息
     * @param userId
     * @param min
     * @return
     */
    @Select("select \"SOFT_ID\",\"SOFT_NAME\",\"PARENT_ID\",\"SOFT_LOGO\",\"LICENSE\",\"EDITION\",\"SOFT_TYPE\"," +
            "\"SOFT_WEB\",\"LANGUAGE\",\"PLATFORM\",\"SOFT_SIZE\",\"SOFT_ADDR\",\"USER_ID\",\"INTRODUCE_ID\"," +
            "\"CREATE_TIME\",\"UPDATE_TIME\",\"VERIFY\",\"DOWNLOADS\"\n" +
            "from \"softpark\".\"SOFTWARE\" " +
            "where \"USER_ID\" = #{userId} order by \"CREATE_TIME\" desc limit #{min},10")
    List<SoftwareEntity> selectByAuthor(String userId, Integer min);


    /**
     * 通过columnId查询软件信息
     * @param columnId
     * @return
     */
    @Select("select * from \"softpark\".\"SOFTWARE\" where \"PARENT_ID\" = #{columnId};")
    List<SoftwareEntity> selectByColumnId(String columnId);

    /**
     * 根据softId查询软件信息
     * @param softId
     * @return
     */
    @Select("select * from \"softpark\".\"SOFTWARE\" where \"SOFT_ID\" = #{softId};\n")
    SoftwareEntity selectBySoftId(String softId);

    /**
     * 根据userid查找用户发布过的软件信息
     * @param userId
     * @return
     */
    @Select("select * from \"softpark\".\"SOFTWARE\" where \"USER_ID\" = #{userId};")
    List<SoftwareEntity> selectByUerId(String userId);
}
