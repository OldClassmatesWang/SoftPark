//package com.yunlong.softpark.mapper;
//
//import com.yunlong.softpark.entity.CommentEntity;
//import com.yunlong.softpark.util.MybatisUtil;
//import org.apache.ibatis.session.SqlSession;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//class testTest {
//
//    private SqlSession sqlSession;
//
//    @Test
//    public void test(){
//        sqlSession = MybatisUtil.getSqlSession();
//        CommentMapper commentMapper = sqlSession.getMapper(CommentMapper.class);
//        List<CommentEntity> commentEntityList = commentMapper.selectByUser_id("1");
//        for(CommentEntity c:commentEntityList){
//            System.out.println(c);
//        }
//        sqlSession.close();
//
//    }
//
//}