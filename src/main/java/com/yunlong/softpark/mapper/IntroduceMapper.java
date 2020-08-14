package com.yunlong.softpark.mapper;


import com.yunlong.softpark.dto.ColumnDetailDto;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 
 * 
 * @author Cui
 * @email ${email}
 * @date 2020-07-21 16:54:16
 */
@Repository
public interface IntroduceMapper {

    /**
     * 根据IntroduceId搜索出简介单中栏目的相关详细信息
     * @param introduceId
     * @return
     */
    @Select("select \"BRIEF_INTRO\",\"FUNCTION\",\"CHARACTER\",\"INSTALL_ADDR\"\n" +
            "from \"softpark\".\"INTRODUCE\" where \"INTRODUCE_ID\" = #{introduceId};")
    ColumnDetailDto selectDataForDetailColumn(String introduceId);
}
