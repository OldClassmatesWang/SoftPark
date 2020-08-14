package com.yunlong.softpark.controller;

import com.yunlong.softpark.core.support.web.controller.BaseController;
import com.yunlong.softpark.core.wrapper.ResultWrapper;
import com.yunlong.softpark.dto.ColumnDetailDto;
import com.yunlong.softpark.dto.ColumnSimDto;
import com.yunlong.softpark.dto.RankDto;
import com.yunlong.softpark.dto.UserInfo;
import com.yunlong.softpark.form.ColumnSimpForm;
import com.yunlong.softpark.service.ColumnService;
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
 * @Date: 2020/7/27
 * @Description:
 */

/**
 * 有关栏目相关功能的接口
 * 1）用于获取排行榜信息的接口
 */
@Api(value = "ColumnController", tags = {"栏目API"})
@RestController
@Slf4j
@RequestMapping("/column")
public class ColumnController extends BaseController<UserInfo> {

    @Autowired
    ColumnService columnService;

    /**
     * 根据栏目的下载量返回前十的栏目
     * @return
     */
    @RequestMapping(path = "/rank",method = RequestMethod.GET)
    ResultWrapper getRankData(){
        System.out.println("接到前端请求！");
        List<RankDto> list= columnService.getRankData();
        return ResultWrapper.successWithData(list);
    }

    /**
     * 根据columnId 搜索出栏目的简单介绍
     * @param columnSimpForm
     * @return
     */
    @RequestMapping(path = "/simpleIntro" , method = RequestMethod.POST)
    ResultWrapper getSimpleIntroduce(@RequestBody ColumnSimpForm columnSimpForm){
        if (columnSimpForm.getColumnId()!=null){
            ColumnSimDto columnSimDto =  columnService.getSimpleIntroduce(columnSimpForm.getColumnId());
            return ResultWrapper.successWithData(columnSimDto);
        }else {
            return ResultWrapper.failure();
        }

    }

    /**
     * 根据columnId 搜出出栏目的详细介绍
     */
    @RequestMapping(path = "/detailIntro" , method = RequestMethod.POST)
    ResultWrapper getDetailIntroduce(@RequestBody ColumnSimpForm columnSimpForm){
        ColumnDetailDto columnDetailDto = columnService.getDetailIntroduce(columnSimpForm.getColumnId());
        return ResultWrapper.successWithData(columnDetailDto);
    }





}
