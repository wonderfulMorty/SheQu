package com.metro.param.line;

import com.metro.pojo.Station;
import lombok.Data;
import org.joda.time.DateTime;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/3/11
 * @Content:
 */
@Data
public class LinePageParam {


    /**
     * 分页大小，默认10
     */
    private Integer rowsOfPage=10;

    /**
     * 当前页码，默认1
     */
    private Integer currentPage=1;
    /**
     * 线路名
     */
    private String name;

    /**
     * 线路id
     */
    private String id;

    /**
     * 线路城市
     */
    private String city;

    /**
     * 线路城市代码
     */
    private String cityCode;

}
