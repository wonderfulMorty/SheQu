package com.metro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.metro.param.station.StationAddParam;
import com.metro.param.station.StationDeleteParam;
import com.metro.param.station.StationPageParam;
import com.metro.param.station.StationUpdateParam;
import com.metro.pojo.FrankResult;
import com.metro.pojo.Station;
import com.metro.pojo.frank.FrankPageAble;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/2/26
 * @Content:
 */
public interface StationService extends IService<Station> {
    FrankResult<Boolean> addStation(StationAddParam param);

    FrankResult<Boolean> deleteStation(StationDeleteParam param);

    FrankResult<Boolean> updateStation(StationUpdateParam param);

    FrankResult<FrankPageAble<Station>> pageData(StationPageParam param);
}
