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
public class StationInLineDeleteParam {
    private Line line;

    private Station station;

    private Integer order;
}
