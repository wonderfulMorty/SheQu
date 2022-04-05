package com.metro.pojo;


import java.util.Comparator;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/2/25
 * @Content:站点的详细信息
 */

@Data
@TableName("station")
public class Station {

    /**
     * 站点id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 站点名称
     */
    private String name;
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
     * 在线路中的顺序
     */
    private Integer lineOrder;
    /**
     * 站点颜色
     */
    private String color;
    /**
     * 坐标定位
     */
    private String location;
    /**
     * 换乘阻抗系数
     */
    private double ratio;

    public Station() {

    }

    public Station(String name, Integer id, String city, String cityCode, String line, Integer lineOrder, String color, String location) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.cityCode = cityCode;
        this.line = line;
        this.color = color;
        this.lineOrder = lineOrder;
        this.location = location;
    }

    public static class Comparators{
        public static Comparator<Station> LINEORDER = new Comparator<Station>(){
            @Override
            public int compare(Station s1, Station s2) {
                Integer line1 = s1.getLineOrder();
                Integer line2 = s2.getLineOrder();
                return line1 - line2;
            }
        };
    }

}
