package com.metro.param.station;

import lombok.Data;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/3/18
 * @Content:
 */
@Data
public class StationDeleteParam {
    /**
     * 站点名称
     */
    private String name;
    /**
     * 站点id
     */
    private Integer id;
}
