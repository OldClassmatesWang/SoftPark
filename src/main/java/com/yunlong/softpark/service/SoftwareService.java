package com.yunlong.softpark.service;

import com.yunlong.softpark.dto.SoftwareBaseDataDto;
import com.yunlong.softpark.dto.SoftwareDetailDto;
import com.yunlong.softpark.dto.SoftwareSimpIntroDto;
import com.yunlong.softpark.dto.SoftwareSimpVersionDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("softwareService")
public interface SoftwareService {

    /**
     * 返回在栏目下栏展示的软件集信息
     * @param columnId
     * @return
     */
    List<SoftwareSimpVersionDto> getSimpVersionIntroduce(String columnId);

    /**
     * 返回在软件点开栏上栏显示的软件简介信息
     * @param softId
     * @return
     */
    SoftwareSimpIntroDto getSimpIntroduc(String softId,String columnId);

    /**
     * 根据软件id返回软件的右安装步骤
     * @param softId
     * @return
     */
    SoftwareDetailDto getDetailIntroduce(String softId);

    /**
     * 根据前端传递的columnId和softId返回软件的信息
     * 点开栏下的基本信息
     * @param columnId
     * @param softId
     * @return
     */
    SoftwareBaseDataDto getBaseData(String columnId, String softId);
}
