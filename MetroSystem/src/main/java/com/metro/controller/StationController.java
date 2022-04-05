package com.metro.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.metro.param.station.StationAddParam;
import com.metro.param.station.StationDeleteParam;
import com.metro.param.station.StationPageParam;
import com.metro.param.station.StationUpdateParam;
import com.metro.pojo.FrankResult;
import com.metro.pojo.Station;
import com.metro.pojo.frank.FrankPageAble;
import com.metro.service.StationService;
import com.metro.util.BeanCopyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/2/26
 * @Content:
 */
@RestController
@RequestMapping("/station")
public class StationController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    StationService stationService;

    //站点信息添加
    @PostMapping("/add")
    public FrankResult<Boolean> addStation(@RequestBody StationAddParam param) {
        Station station = BeanCopyUtils.copyProperties(param, Station.class);
        return FrankResult.success(stationService.addStation(param));
    }

    //站点信息删除
    @PostMapping("/delete")
    public FrankResult<Boolean> deleteStation(@RequestBody StationDeleteParam param) {
        return stationService.deleteStation(param);
    }

    //站点信息查看
    @PostMapping("/page")
    public FrankResult<FrankPageAble<Station>> pageStation(@RequestBody StationPageParam param) {
        logger.info("page 获取的参数：{}", JSON.toJSONString(param));
        return stationService.pageData(param);
    }

    //站点信息编辑
    @PostMapping("/edit")
    public FrankResult<Boolean> editStation(@RequestBody StationUpdateParam param) {
        Station station = BeanCopyUtils.copyProperties(param, Station.class);
        stationService.update(station, new LambdaQueryWrapper<Station>().eq(Station::getId, param.getId()));
        return FrankResult.success(true);
    }




}
