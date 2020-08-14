package com.yunlong.softpark.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author 王海澎
 * @Date 2020/7/27 17:55
 * @Version 1.0
 */

/**
 * 加载Mybatis，获取SqlSession
 */
//@Configuration
public class MybatisUtil {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        String source = "Mybatis.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(source);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
