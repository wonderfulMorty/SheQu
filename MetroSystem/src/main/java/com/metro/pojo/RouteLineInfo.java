package com.metro.pojo;

import lombok.Data;

import java.util.List;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/4/4
 * @Content:
 */
@Data
public class RouteLineInfo {

    /**
     * 线路名
     */
    private String lineName;

    /**
     * 线路方向
     */
    private String direction;

    /**
     * 区间起点
     */
    private String startPoint;

    /**
     * 区间终点
     */
    private String endPoint;

    /**
     * 区间长度
     */
    private Integer length;

    /**
     * 区间频率
     */
    private Integer rate;

    /**
     * 途径的站点
     */
    private List<String> station;
}
