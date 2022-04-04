package com.metro.service;

import com.metro.param.route.RouteSearchParam;
import com.metro.pojo.Route;
import com.metro.pojo.FrankResult;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/4/4
 * @Content:
 */
public interface RouteService {

    FrankResult<Route> findRoute(RouteSearchParam param);

}
