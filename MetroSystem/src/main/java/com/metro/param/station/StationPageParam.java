package com.metro.param.station;

import lombok.Data;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/3/18
 * @Content:
 */
@Data
public class StationPageParam {

    private static final long serialVersionUID = 1L;
    private Integer rowsOfPage;
    private Integer currentPage;
    private String hotelName;

    /**
     * 站点名称
     */
    private String name;
    /**
     * 站点id
     */
    private Integer id;
    /**
     * 所在线路
     */
    private String line;
}
