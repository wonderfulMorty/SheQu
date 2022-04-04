package com.metro.param.route;

import lombok.Data;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/4/4
 * @Content:
 */
@Data
public class RouteSearchParam {

    /**
     * 起点
     */
    private String startPoint;

    /**
     * 终点
     */
    private String endPoint;
}
