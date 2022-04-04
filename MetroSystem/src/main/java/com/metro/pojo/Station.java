package com.metro.pojo;


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
    private List<String> line;
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

    public Station() {

    }

    public Station(String name, Integer id, String city, String cityCode, List<String> line, boolean isExchange, String color) {
        this.setName(name);
        this.setId(id);
        this.setCity(city);
        this.setCityCode(cityCode);
        this.setLine(line);
        this.setExchange(isExchange);
        this.setColor(color);
    }

}
