package com.metro.result;

import com.metro.pojo.Station;
import org.joda.time.DateTime;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/3/11
 * @Content:
 */
public class LineResult {
    /**
     * 线路名
     */
    private String name;

    /**
     * 线路id
     */
    private String id;

    /**
     * 线路城市
     */
    private String city;

    /**
     * 线路城市代码
     */
    private String cityCode;

    /**
     * 线路颜色
     */
    private String color;

//    /**
//     * 线路中的站点信息
//     */
//    private List<StationInLine> stationInLines;

    /**
     * 地铁站点数量
     */
    private Integer length;

    /**
     * 起始站
     */
    private Station beginStation;

    /**
     * 终点站
     */
    private Station endStation;

    /**
     * 起始时间
     */
    private DateTime beginTime;

    /**
     * 结束时间
     */
    private DateTime endTime;

    /**
     * 是否是反向路线
     * 注：即起始站和终点站相反的
     */
    private boolean isReverse;
}
