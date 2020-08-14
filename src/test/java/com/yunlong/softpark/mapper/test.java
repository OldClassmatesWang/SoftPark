package com.yunlong.softpark.mapper;

import com.yunlong.softpark.dto.RankDto;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author 王海澎
 * @Date 2020/7/27 21:54
 * @Version 1.0
 */
@Ignore
@SpringBootTest
public class test {
    @Autowired
    CommentMapper commentMapper;


    @Test
    public void test(){
        RankDto dto1  = new RankDto();
        dto1.setDownloads(1);

        RankDto dto2  = new RankDto();
        dto2.setDownloads(2);

        RankDto dto3  = new RankDto();
        dto3.setDownloads(3);


        List<RankDto> list = new ArrayList<>();
        list.add(dto1);
        list.add(dto2);
        list.add(dto3);

        Collections.sort(list,new Comparator<RankDto>(){
            @Override
            public int compare(RankDto rankDto, RankDto t1) {
                if (rankDto.getDownloads()>t1.getDownloads()){
                    return -1;
                }else if (rankDto.getDownloads()==t1.getDownloads()){
                    return 0;
                }else {
                    return 1;
                }
            }
        });

        System.out.println(list);
    }

}
