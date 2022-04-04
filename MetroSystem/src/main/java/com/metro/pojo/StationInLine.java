package com.metro.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/2/28
 * @Content:线路中的站点信息
 */
@Data
@TableName("station_in_line")
public class StationInLine{

    /**
     * 站点名称
     */
    private String name;

    /**
     * 站点id
     */
    private String id;

    /**
     * 站点所在城市
     */
    private String city;

    /**
     * 站点所在城市代码
     */
    private String cityCode;

    /**
     * 当前站点信息所在线路
     * 会出现同名站点
     */
    private String lineName;


    /**
     * 站点在线路中的顺序
     */
    private Integer lineOrder;

    /**
     * 到上一站的时间
     */
    private double timeToPre;

    /**
     * 到下一站的时间
     */
    private double timeToNxt;

    /**
     * 是否是起始站
     */
    private Integer isBeginStation;

    /**
     * 是否是终点站
     */
    private Integer isEndStation;


    public StationInLine(double timeToPre, double timeToNxt, Integer isBeginStation, Integer isEndStation) {
        this.setTimeToPre(timeToPre);
        this.setTimeToNxt(timeToNxt);
        this.setIsBeginStation(isBeginStation);
        this.setIsEndStation(isEndStation);
    }

    public StationInLine() {

    }
}
