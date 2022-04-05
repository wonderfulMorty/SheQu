package com.metro.result;

import com.metro.pojo.Route;
import lombok.Data;

import java.util.List;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/4/4
 * @Content:
 */
@Data
public class RouteResult {
    private Route route;

    private List<String> list;

}
