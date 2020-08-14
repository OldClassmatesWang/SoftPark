package com.yunlong.softpark.service.impl;

import com.yunlong.softpark.dto.*;
import com.yunlong.softpark.entity.SoftwareEntity;
import com.yunlong.softpark.entity.UserEntity;
import com.yunlong.softpark.mapper.ColumnMapper;
import com.yunlong.softpark.mapper.SoftwareMapper;
import com.yunlong.softpark.mapper.UserMapper;
import com.yunlong.softpark.service.SoftwareService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Cui
 * @Date: 2020/7/24
 * @Description:
 */
@Slf4j
@Service
public class SoftwareServiceImpl implements SoftwareService {

    @Autowired
    SoftwareMapper softwareMapper;

    @Autowired
    ColumnMapper columnMapper;

    @Autowired
    UserMapper userMapper;

    /**
     * 返回在栏目下栏展示的软件集信息
     *
     * @param columnId
     * @return
     */
    @Override
    public List<SoftwareSimpVersionDto> getSimpVersionIntroduce(String columnId) {
        List<SoftwareEntity> list = softwareMapper.selectByColumnId(columnId);

        List<SoftwareSimpVersionDto> list1 = new ArrayList<>();
        for (SoftwareEntity softwareEntity : list) {
            if (softwareEntity.getVerify() == 1) {
                SoftwareSimpVersionDto ssvd = new SoftwareSimpVersionDto();
                ssvd.setSoftName(softwareEntity.getSoftName());
                ssvd.setSoftLogo(softwareEntity.getSoftLogo());
                ssvd.setDownloads(softwareEntity.getDownloads());
                ssvd.setEdition(softwareEntity.getEdition());
                ssvd.setPlatform(softwareEntity.getPlatform());
                ssvd.setSoftAddr(softwareEntity.getSoftAddr());
                ssvd.setSoftSize(softwareEntity.getSoftSize());
                ssvd.setBriefIntro(softwareEntity.getBriefIntro());

                Date date = softwareEntity.getUpdateTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String time = sdf.format(date);
                ssvd.setUpdateTime(time);
                list1.add(ssvd);
            }
        }

        return list1;
    }

    /**
     * 返回在软件点开栏上栏显示的软件简介信息
     *
     * @param softId
     * @return
     */
    @Override
    public SoftwareSimpIntroDto getSimpIntroduc(String softId, String columnId) {
        SoftwareEntity softwareEntity = softwareMapper.selectBySoftId(softId);

        ColumnSimDto simDto = columnMapper.selectDataForSimpleColumn(columnId);

        SoftwareSimpIntroDto simpIntroDto = new SoftwareSimpIntroDto();

        simpIntroDto.setSoftName(softwareEntity.getSoftName());
        simpIntroDto.setBriefIntro(softwareEntity.getBriefIntro());
        simpIntroDto.setColumnWeb(simDto.getColumnWeb());
        simpIntroDto.setDownloads(softwareEntity.getDownloads());
        simpIntroDto.setEdition(softwareEntity.getEdition());
        simpIntroDto.setShowPic(softwareEntity.getShowPic());
        simpIntroDto.setSoftLogo(softwareEntity.getSoftLogo());
        simpIntroDto.setSoftSize(softwareEntity.getSoftSize());
        simpIntroDto.setPlatform(softwareEntity.getPlatform());

        return simpIntroDto;
    }

    /**
     * 根据软件id返回软件的右安装步骤
     *
     * @param softId
     * @return
     */
    @Override
    public SoftwareDetailDto getDetailIntroduce(String softId) {
        SoftwareEntity softwareEntity = softwareMapper.selectBySoftId(softId);
        SoftwareDetailDto softwareDetailDto =new SoftwareDetailDto();
        softwareDetailDto.setInstallProRight(softwareEntity.getInstallProRight());
        return softwareDetailDto;
    }

    /**
     * 根据前端传递的columnId和softId返回软件的信息
     * 点开栏下的基本信息
     *
     * @param columnId
     * @param softId
     * @return
     */
    @Override
    public SoftwareBaseDataDto getBaseData(String columnId, String softId) {
        SoftwareBaseDataDto softwareBaseDataDto = new SoftwareBaseDataDto();

        String columnWeb = columnMapper.selectDataForBaseData(columnId);
        SoftwareEntity softwareEntity = softwareMapper.selectBySoftId(softId);
        UserEntity userEntity = userMapper.selectById(softwareEntity.getUserId());

        softwareBaseDataDto.setColumnWeb(columnWeb);
        softwareBaseDataDto.setUsername(userEntity.getUsername());
        softwareBaseDataDto.setLanguage(softwareEntity.getLanguage());
        softwareBaseDataDto.setEdition(softwareEntity.getEdition());
        softwareBaseDataDto.setSoftAddr(softwareEntity.getSoftAddr());

        return softwareBaseDataDto;
    }


}
