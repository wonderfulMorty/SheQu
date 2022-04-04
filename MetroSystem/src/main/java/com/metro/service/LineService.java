package com.metro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.metro.param.line.*;
import com.metro.pojo.FrankResult;
import com.metro.pojo.Line;
import com.metro.pojo.Station;
import com.metro.pojo.frank.FrankPageAble;

import java.util.List;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/2/28
 * @Content:
 */

public interface LineService extends IService<Line> {
    Boolean addLine(LineAddParam param);

    Boolean deleteLine(LineDeleteParam param);

    Boolean updateLine(LineUpdateParam param);

    FrankResult<FrankPageAble<Line>> pageLine(LinePageParam param);

    FrankResult getLine(LineGetParam param);

    Boolean updateBeginStation(String lineName, String beginStation);

    Boolean updateEndStation(String lineName, String EndStation);

    Integer getLength(String lineName);

    void updateLength(String lineName, Integer length);

    List getSameLines(Station start, Station end);
}
