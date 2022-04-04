package com.metro.controller;

import com.metro.param.stationInLine.*;
import com.metro.pojo.FrankResult;
import com.metro.pojo.Line;
import com.metro.pojo.Station;
import com.metro.pojo.StationInLine;
import com.metro.pojo.frank.FrankPageAble;
import com.metro.service.StationInLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/2/28
 * @Content:
 */
@RestController
@RequestMapping("/stationInLine")
public class StationInLineController {

    @Autowired
    StationInLineService stationInLineService;

    @PostMapping("/add")
    public FrankResult<Boolean> addStationInLine(@RequestBody StationInLineAddParam param) {
        return stationInLineService.addStationInLine(param);
    }

    @PostMapping("/update")
    public FrankResult<Boolean> updateStationInLine(StationInLineUpdateListParam param) {
        return stationInLineService.updateStationInLine(param);
    }

    @PostMapping("/delete")
    public FrankResult<Boolean> deleteStationInLine(StationInLineDeleteParam param) {
        return stationInLineService.deleteStationInLine(param);
    }

    @PostMapping("/page")
    public FrankResult<FrankPageAble<StationInLine>> Page(StationInLinePageParam param) {
        return stationInLineService.pageData(param);
    }
}
