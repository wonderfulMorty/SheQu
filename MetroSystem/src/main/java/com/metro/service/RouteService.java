package com.metro.service;

import com.metro.param.route.RouteSearchParam;
import com.metro.pojo.Route;
import com.metro.pojo.FrankResult;
import com.metro.result.RouteResult;

import java.util.List;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/4/4
 * @Content:
 */
public interface RouteService {

    FrankResult<Route> findRoute(RouteSearchParam param);

    List<RouteResult> searchRoute(String start, String end);

}
