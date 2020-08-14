package com.yunlong.softpark.service.impl;

import com.yunlong.softpark.dto.ColumnDetailDto;
import com.yunlong.softpark.dto.ColumnSimDto;
import com.yunlong.softpark.dto.RankDto;
import com.yunlong.softpark.mapper.ColumnMapper;
import com.yunlong.softpark.mapper.IntroduceMapper;
import com.yunlong.softpark.service.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: Cui
 * @Date: 2020/7/27
 * @Description:
 */
@Service
public class ColumnServiceImpl implements ColumnService {

    @Autowired
    ColumnMapper columnMapper;

    @Autowired
    IntroduceMapper introduceMapper;
    /**
     * 返回排行榜下载次数的前十位
     *
     * @return
     */
    @Override
    public List<RankDto> getRankData() {
        List<RankDto> list = columnMapper.selectDataForRank();
        list.sort(Comparator.comparing(RankDto::getDownloads).reversed());
        List<RankDto> list1 = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i ++){
            list1.add(list.get(i));
        }

        return list1;
    }

    /**
     * 返回栏目的简单介绍
     *
     * @return
     */
    @Override
    public ColumnSimDto getSimpleIntroduce(String columnId) {
        ColumnSimDto columnSimDto = columnMapper.selectDataForSimpleColumn(columnId);

        return columnSimDto;
    }

    /**
     * 返回栏目的详细介绍
     *
     * @param columnId
     * @return
     */
    @Override
    public ColumnDetailDto getDetailIntroduce(String columnId) {
        String introduceId = columnMapper.selectIntroducIdBycolumnId(columnId);
        ColumnDetailDto columnDetailDto = introduceMapper.selectDataForDetailColumn(introduceId);
        return columnDetailDto;
    }


}
