package com.metro.pojo;

import lombok.Data;

import java.util.Map;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/2/28
 * @Content:
 */
@Data
public class StationExit {

    private String name;

    private String id;

    private String city;

    private String cityCode;

    private Map<String, String> exits;
}
