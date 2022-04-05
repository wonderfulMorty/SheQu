package com.metro.controller;

import com.metro.param.route.RouteSearchParam;
import com.metro.pojo.FrankResult;
import com.metro.result.RouteResult;
import com.metro.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/4/4
 * @Content:
 */
@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    RouteService routeService;

    @PostMapping("/search")
    public FrankResult<List<RouteResult>> search(@RequestBody RouteSearchParam param) {
        return FrankResult.success(routeService.searchRoute(param.getStartPoint(), param.getEndPoint()));
    }


}
