package com.metro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.metro.param.line.LineInsert;
import com.metro.param.route.RouteSearchParam;
import com.metro.pojo.*;
import com.metro.result.RouteResult;
import com.metro.service.*;
import com.sun.media.jfxmedia.logging.Logger;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/4/4
 * @Content:
 */
@Service
public class RouteServiceImpl implements RouteService {

    protected final org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    StationService stationService;

    @Autowired
    LineService lineService;

    @Autowired
    LineInsertService lineInsertService;

    @Autowired
    StationInLineService stationInLineService;

    @Autowired
    StationInRouteService stationInRouteService;

    @Override
    public FrankResult<Route> findRoute(RouteSearchParam param) {
        Route route = new Route();


        return FrankResult.success(route);
    }

    public List<RouteResult> searchRoute(String start, String end) {


        List<StationInRoute> stationInRouteList = stationInRouteService.listStationInRoute();

        if (stationService.count(new LambdaQueryWrapper<Station>().eq(Station::getName, start)) == 0) {
            logger.info("起始站有误，请重新检查站点名称");
            return null;
        }
        if (stationService.count(new LambdaQueryWrapper<Station>().eq(Station::getName, end)) == 0) {
            logger.info("终点站有误，请重新检查站点名称");
            return null;
        }

        //总站点数
        int stationsNum = stationInRouteService.listStationInRoute().size();
        Route[][] routes = new Route[stationsNum][stationsNum];

        int index = 0;
        List<StationInRoute> stationInRoutes = new ArrayList<>();
        List<StationInRoute> list = stationInRouteService.listStationInRoute();
        Map<String, Integer> stationIndex = new HashMap<>();

        //遍历所有站点，将所有站点的名称存入map,将所有站点存入stations
        for (StationInRoute station : list) {
            stationIndex.put(station.getName(), index);
            stationInRoutes.add(station);
            index++;
        }

        for (int i = 0; i < stationInRoutes.size(); i++) {
            for (int j = 0; j < stationInRoutes.size(); j++) {
                List sameLines = lineInsertService.getSameLines(stationInRoutes.get(i), stationInRoutes.get(j));
                routes[i][j] = this.getFastRouter(stationInRoutes.get(i).getName(), stationInRoutes.get(j).getName(), sameLines);
            }
        }

        //获取到起始站和终点站对应的index
        Integer startIndex = stationIndex.get(start);
        Integer endIndex = stationIndex.get(end);


        Circuit[] circuits = new Circuit[routes.length - 1];
        int[] book = new int[routes.length - 1];

        for (int i = 0; i < routes.length - 1; i++) {
            Circuit circuit = new Circuit();
            List<Route> list1 = new ArrayList<>();
            list1.add(routes[startIndex][i]);
            circuit.setLength(routes[startIndex][i].getLength());
            circuit.setRoutes(list1);
            circuits[i] = circuit;
            book[i] = 0;
        }

        book[0] = 1;
        int u = 0;
        int num = stationInRoutes.size();

        for (int i = 0; i < num - 1; i++) {
            Circuit minCircuit = new Circuit();
            minCircuit.setLength(32767);
            List<Route> routes1 = new ArrayList<>();
            routes1.add(new Route());
            minCircuit.setRoutes(routes1);

            for (int j = 0; j < num - 1; j++) {
                if (book[j] == 0 && circuits[j].getLength() < minCircuit.getLength()) {
                    minCircuit = circuits[j];
                    u = j;
                }
            }
            book[u] = 1;

            for (int k = 0; k < num - 1; k++) {
                if (routes[u][k].getLength() <= 32767) {
                    if (book[k] == 0 && circuits[k].getLength() > (circuits[u].getLength() + routes[u][k].getLength() + 30)) {
                        List<Route> list1 = new ArrayList<>();
                        for (Route route : circuits[u].getRoutes()) {
                            list1.add(route);
                        }
                        list1.add(routes[u][k]);
                        Circuit circuit = new Circuit();
                        circuit.setLength(circuits[u].getLength() + routes[u][k].getLength());
                        circuit.setRoutes(list1);
                        circuits[k] = circuit;
                    }
                }
            }
        }

        List<RouteResult> finalRoute = new ArrayList<>();

        for (Route route : circuits[endIndex].getRoutes()) {
            RouteResult result = new RouteResult();
            result.setRoute(route);
            result.setList(stopStations(route.getLine(), route.getStartPoint(), route.getEndPoint()));
            finalRoute.add(result);
        }
        return finalRoute;

    }

    public List<String> stopStations(String line, String start, String end) {
        Integer startIndex = 0;
        Integer endIndex = 0;

//        Line line1 = lineService.getOne(new LambdaQueryWrapper<Line>().eq(Line::getName, line));
        LineInsert lineInsert = lineInsertService.selectLineInsert(line);

        //经过的站点
        List<String> passStation = new ArrayList();
        List<String> station = lineInsert.getStation();

        for (int i = 0; i < station.size(); i++) {
            if (station.get(i).equals(start)) {
                startIndex = i;
            } else if (station.get(i).equals(end)) {
                endIndex = i;
            }
        }

        if (startIndex < endIndex) {
            for (String station1 : station) {
                Boolean flag = false;
                if (station1.equals(start)) {
                    passStation.add(station1);
                    flag = true;
                } else if (flag) {
                    passStation.add(station1);
                } else if (station1.equals(end)) {
                    passStation.add(station1);
                    flag = false;
                }
            }
        } else {
            Collections.reverse(station);
            Boolean flag = false;
            for (String station1 : station) {
                if (station1.equals(start)) {
                    passStation.add(station1);
                    flag = true;
                } else if (flag) {
                    passStation.add(station1);
                } else if (station1.equals(end)) {
                    passStation.add(station1);
                    flag = false;
                }
            }
        }
        return passStation;
    }

    /**
     * @param start
     * @param end
     * @param list
     * @return
     * 获取最快路径
     */
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
        for (LineInsert lineInsert : lineInsertService.selectLineInsertAll()) {
            if (list.contains(lineInsert.getName())) {
                int startNum = 0;
                int endNum = 0;
                for (int i = 0; i < lineInsert.getStation().size(); i++) {
                    if (lineInsert.getStation().get(i).equals(start)) {
                        startNum = i;
                    } else if (lineInsert.getStation().get(i).equals(end)) {
                        endNum = i;
                    }
                }
                //起始站到终点站中间站数
                Integer gapNum = Math.abs(startNum - endNum);
                //如果中间站数少于之间的线路长度 gapNum设为新的线路长度
                if (gapNum < route.getLength()) {
                    route.setLength(gapNum);
                    route.setLine(lineInsert.getName());
                }
            }
        }
        return route;
    }

}
