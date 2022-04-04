package com.metro.param.stationInLine;

import lombok.Data;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/3/10
 * @Content:
 */
@Data
public class StationInLineUpdateParam {
    private String name;

    private String id;

    private String city;

    private String cityCode;

    private String lineName;

    private Integer lineOrder;

    private double timeToPre;

    private double timeToNxt;

    private Integer isBeginStation;

    private Integer isEndStation;
}
