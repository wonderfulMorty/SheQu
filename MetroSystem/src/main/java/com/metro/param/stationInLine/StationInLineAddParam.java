package com.metro.param.stationInLine;

import com.metro.pojo.Line;
import com.metro.pojo.Station;
import lombok.Data;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/3/9
 * @Content:
 */
@Data
public class StationInLineAddParam {
    private Line line;

    private Station station;

    /**
     * 新加入的站点在线路中的次序
     */
    private Integer lineOrder;

    /**
     * 新加入的站点到下一站的时间
     */
    private double timeToNxt;

    /**
     * 新加入的站点到上一站的时间
     */
    private double timeToPre;
}
