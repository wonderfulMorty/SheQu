package com.metro.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/4/5
 * @Content:
 */
@Data
public class StationInRoute {
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
    private List<String> line;
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

    public void addLine(String newLine) {
        this.line.add(newLine);
    }

    public void setLine(List<String> list) {
        this.line = new ArrayList<>();
        for (String line : list) {
            this.line.add(line);
        }
    }
}
