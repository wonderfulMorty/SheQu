package com.metro.param.lineInsert;

import lombok.Data;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/4/5
 * @Content:
 */
@Data
public class LineInsertPageParam {
    /**
     * 分页大小，默认10
     */
    private Integer rowsOfPage=10;

    /**
     * 当前页码，默认1
     */
    private Integer currentPage=1;
}
