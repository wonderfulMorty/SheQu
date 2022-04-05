package com.metro.service.impl;

import com.metro.pojo.Station;
import com.metro.pojo.StationInRoute;
import com.metro.service.StationInRouteService;
import com.metro.service.StationService;
import com.metro.util.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/4/5
 * @Content:
 */
@Service
public class StationInRouteServiceImpl implements StationInRouteService {

    @Autowired
    StationService stationService;

    /**
     * @return
     * 把原先station类型的数据重新组装成StationInRoute类型的数据
     * 主要为String line -> List<String> line
     */
    @Override
    public List<StationInRoute> listStationInRoute() {
        List<Station> stations = stationService.list();
        List<StationInRoute> stationInRoutes = new ArrayList<>();

        List<String> list = new ArrayList<>();
        list.add(stations.get(0).getLine());
        StationInRoute tempStationInRoute = BeanCopyUtils.copyProperties(stations.get(0), StationInRoute.class);
        tempStationInRoute.setLine(list);
        stationInRoutes.add(tempStationInRoute);

        for (int i = 1; i < stations.size(); i++) {
            for (int j = 0; j < stationInRoutes.size(); j++) {
                //如果站点同名且station.get(i)所在线路不存在于stationInRoutes.get(j)时
                if (stationInRoutes.get(j).getName().equals(stations.get(i).getName()) && !stationInRoutes.get(j).getLine().contains(stations.get(i).getLine())) {
                    //将原先的List取出来 添加新的元素在重新设List
                    List<String> tempList = stationInRoutes.get(j).getLine();
                    tempList.add(stations.get(i).getLine());
                    stationInRoutes.get(j).setLine(tempList);
                    break;
                } else {
                    //如果没有同名站点，就将station.get(i)存入stationInRoutes总
                    StationInRoute stationInRoute = BeanCopyUtils.copyProperties(stations.get(i), StationInRoute.class);
                    List<String> tempList = new ArrayList<>();
                    tempList.add(stations.get(i).getLine());
                    stationInRoute.setLine(tempList);
                    stationInRoutes.add(stationInRoute);
                    break;
                }
            }
        }
        return stationInRoutes;
    }
}
