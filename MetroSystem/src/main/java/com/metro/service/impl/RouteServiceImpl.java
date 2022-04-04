package com.metro.service.impl;

import com.metro.param.route.RouteSearchParam;
import com.metro.pojo.*;
import com.metro.service.LineService;
import com.metro.service.RouteService;
import com.metro.service.StationInLineService;
import com.metro.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/4/4
 * @Content:
 */
public class RouteServiceImpl implements RouteService {

    @Autowired
    StationService stationService;

    @Autowired
    LineService lineService;

    @Autowired
    StationInLineService stationInLineService;

    @Override
    public FrankResult<Route> findRoute(RouteSearchParam param) {
        Route route = new Route();


        return FrankResult.success(route);
    }

    public void test() {

        int stationsNum = stationService.list().size();
        Route[][] routes = new Route[][];

        int index = 0;
        List<Station> stations = new ArrayList<>();
        List<Station> list = stationService.list();
        Map<String, Integer> stationIndex = new HashMap<>();

        //遍历所有站点，将所有站点的名称存入map,将所有站点存入stations
        for (Station station : list) {
            stationIndex.put(station.getName(), index);
            stations.add(station);
            index++;
        }

        for (int i = 0; i < stations.size(); i++) {
            for (int j = 0; j < stations.size(); j++) {
                List sameLines = lineService.getSameLines(stations.get(i), stations.get(j));
                routes[i][j] =
            }
        }
    }

    public Route getFastRouter(String start, String end, List<String> list) {
        Route route = new Route();
        route.setStartPoint(start);
        route.setEndPoint(end);
        route.setLength(32767);

        //无法直接到达
        if (null == list || 0 == list.size()) {
            return route;
        }

        //遍历所有线路
        for (StationInLine stationInLine : stationInLineService.list()) {
            if (list.contains(stationInLine.getName())) {
                int startNum = 0;
                int endNum = 0;
                for (int i = 0; i < stationInLine; i++) {
                    if()
                }
            }
        }
    }

}
