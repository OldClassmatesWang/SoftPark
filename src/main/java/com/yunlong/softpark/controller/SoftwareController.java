package com.yunlong.softpark.controller;

import com.yunlong.softpark.core.support.web.controller.BaseController;
import com.yunlong.softpark.core.wrapper.ResultWrapper;
import com.yunlong.softpark.dto.*;
import com.yunlong.softpark.form.ColumnSimpForm;
import com.yunlong.softpark.form.SoftwareSimpForm;
import com.yunlong.softpark.service.SoftwareService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Cui
 * @Date: 2020/7/24
 * @Description:
 */

/**
 * 基于软件信息功能
 * 1）返回软件的基本信息(下载版本栏)
 * 2）返回软件的基本信息（点开栏）
 * 3）返回软件的详细信息（安装步骤）
 */
@Api(value = "SoftwareController", tags = {"软件API"})
@RestController
@Slf4j
@RequestMapping("/software")
public class SoftwareController extends BaseController<UserInfo> {

    @Autowired
    SoftwareService softwareService;

    /**
     * 根据前端传入的columnId获取在栏目栏展示的软件相关信息
     *
     * @param columnSimpForm
     * @return
     */
    @RequestMapping(path = "/versionShow", method = RequestMethod.POST)
    ResultWrapper getSimpVersionIntroduce(@RequestBody ColumnSimpForm columnSimpForm) {
        List<SoftwareSimpVersionDto> list = softwareService.getSimpVersionIntroduce(columnSimpForm.getColumnId());
        return ResultWrapper.successWithData(list);
    }

    /**
     * 根据前端传入的softId获取在软件点开栏上方的简单信息
     *
     * @param softwareSimpForm
     * @return
     */
    @RequestMapping(path = "/simpInto", method = RequestMethod.POST)
    ResultWrapper getSimpIntroduce(@RequestBody SoftwareSimpForm softwareSimpForm) {
        SoftwareSimpIntroDto simpIntroduc = softwareService.getSimpIntroduc(softwareSimpForm.getSoftId(), softwareSimpForm
                .getColumnId());


        return ResultWrapper.successWithData(simpIntroduc);
    }

    /**
     * 根据前端传入的softid获取软件点开栏的安装步骤右
     * @param softwareSimpForm
     * @return
     */
    @RequestMapping(path = "/detailIntro",method = RequestMethod.POST)
    ResultWrapper getDetailIntroduce(@RequestBody SoftwareSimpForm softwareSimpForm) {
        SoftwareDetailDto softwareDetailDto = softwareService.getDetailIntroduce(softwareSimpForm.getSoftId());
        return ResultWrapper.successWithData(softwareDetailDto);
    }

    @RequestMapping(path = "/basedata",method = RequestMethod.POST)
    ResultWrapper getBaseData(@RequestBody SoftwareSimpForm softwareSimpForm){
        SoftwareBaseDataDto softwareBaseDataDto = softwareService.getBaseData(softwareSimpForm.getColumnId(),softwareSimpForm.getSoftId());
        return ResultWrapper.successWithData(softwareBaseDataDto);
    }

}
