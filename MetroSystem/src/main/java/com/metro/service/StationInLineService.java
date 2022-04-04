package com.metro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.metro.param.stationInLine.*;
import com.metro.pojo.FrankResult;
import com.metro.pojo.Line;
import com.metro.pojo.Station;
import com.metro.pojo.StationInLine;
import com.metro.pojo.frank.FrankPageAble;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/2/28
 * @Content:
 */
public interface StationInLineService extends IService<StationInLine> {

    FrankResult<Boolean> addStationInLine(StationInLineAddParam param);

    FrankResult<Boolean> deleteStationInLine(StationInLineDeleteParam param);

    FrankResult<Boolean> updateStationInLine(StationInLineUpdateListParam param);

    FrankResult<FrankPageAble<StationInLine>> pageData(StationInLinePageParam param);

}
