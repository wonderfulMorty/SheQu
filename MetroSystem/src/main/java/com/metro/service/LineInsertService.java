package com.metro.service;

import com.metro.param.line.LineGetParam;
import com.metro.param.line.LineInsert;
import com.metro.pojo.LineStartAndEnd;
import com.metro.pojo.StationInRoute;
import com.metro.result.LineResult;

import java.util.List;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/4/5
 * @Content:
 */
public interface LineInsertService {

    LineResult getLine(LineGetParam param);

    List<String> selectStations(String lineName);

    List<LineInsert> selectLineInsertAll();

    LineInsert selectLineInsert(String lineName);

    LineStartAndEnd getStartEnd(String lineName);

    Integer getLength(String lineName);

    List getSameLines(StationInRoute start, StationInRoute end);
}
