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
public class Circuit {
    /**
     * 经过的长度
     */
    private int length;

    /**
     * 经过的线路
     */
    private List<Route> routes;
}
