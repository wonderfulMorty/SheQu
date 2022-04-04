package com.metro.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.joda.time.DateTime;

import java.util.List;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/2/26
 * @Content:
 */
@Data
@TableName("line")
public class Line {

    /**
     * 线路id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 线路名
     */
    private String name;

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

    /**
     * 线路中的站点信息
     */
    private List<Station> station;

    /**
     * 地铁站点数量
     */
    private Integer length;

    /**
     * 起始站
     */
    private String beginStation;

    /**
     * 终点站
     */
    private String endStation;

    /**
     * 起始时间
     */
    private String beginTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 是否是反向路线
     * 注：即起始站和终点站相反的
     */
    private boolean isReverse;

    public Line(String name, String id, String city, String cityCode, String color, Integer length, String beginStation, String endStation, String beginTime, String endTime, boolean isReverse) {
        this.name = name;
        this.id = id;
        this.city = city;
        this.cityCode = cityCode;
        this.color = color;
        this.length = length;
        this.beginStation = beginStation;
        this.endStation = endStation;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.isReverse = isReverse;
    }

    public Line() {
    }
}
