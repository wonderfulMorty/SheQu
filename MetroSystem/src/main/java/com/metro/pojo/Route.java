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
public class Route {
    /**
     * 起点站
     */
    private String startPoint;

    /**
     * 终点站
     */
    private String endPoint;

    /**
     * 经过的站点数
     */
    private Integer length;

    /**
     * 未换乘
     */
    private List<RouteLineInfo> line1;

    /**
     * 第一次换乘
     */
    private List<RouteLineInfo> line2;

    /**
     * 第二次换乘
     */
    private List<RouteLineInfo> line3;

    /**
     * 第三次换乘
     */
    private List<RouteLineInfo> line4;

    /**
     * 所用的时间
     */
    private double time;
}
