package com.metro.param.stationInLine;

import lombok.Data;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/3/23
 * @Content:
 */
@Data
public class StationInLinePageParam {

    private static final long serialVersionUID = 1L;
    private Integer rowsOfPage;
    private Integer currentPage;
    private String hotelName;

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



}
