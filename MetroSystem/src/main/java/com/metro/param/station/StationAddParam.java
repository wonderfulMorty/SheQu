package com.metro.param.station;

import lombok.Data;

import java.util.List;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/3/18
 * @Content:
 */
@Data
public class StationAddParam {
    /**
     * 站点名称
     */
    private String name;
    /**
     * 站点id
     */
    private Integer id;
    /**
     * 站点所在城市
     */
    private String city;
    /**
     * 站点所在城市代码
     */
    private String cityCode;
    /**
     * 站点所在线路
     */
    private String line;
    /**
     * 站点颜色
     */
    private String color;
    /**
     * 是否是换乘站
     */
    private boolean isExchange;
    /**
     * 坐标定位
     */
    private String location;
}
