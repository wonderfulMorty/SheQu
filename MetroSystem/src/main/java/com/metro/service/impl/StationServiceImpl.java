package com.metro.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.metro.mapper.StationMapper;
import com.metro.param.station.StationAddParam;
import com.metro.param.station.StationDeleteParam;
import com.metro.param.station.StationPageParam;
import com.metro.param.station.StationUpdateParam;
import com.metro.pojo.FrankResult;
import com.metro.pojo.Station;
import com.metro.pojo.StationInRoute;
import com.metro.pojo.frank.FrankPageAble;
import com.metro.pojo.frank.FrankPageInfo;
import com.metro.service.StationService;
import com.metro.util.BeanCopyUtils;
import com.metro.util.ObjectUtils;
import com.metro.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/2/26
 * @Content:
 */
@Service
public class StationServiceImpl extends ServiceImpl<StationMapper, Station> implements StationService{

    @Autowired
    StationMapper stationMapper;

    /**
     * @param param
     * @return
     * 添加站点信息
     */
    @Override
    public Boolean addStation(StationAddParam param) {
        if (null != param.getName()) {
            Station station = this.getOne(new LambdaQueryWrapper<Station>().eq(Station::getName, param.getName())
            .eq(Station::getLine, param.getLine())
            .eq(Station::getCity, param.getCity()));
            if (null == station) {
                this.save(BeanCopyUtils.copyProperties(param, Station.class));
//                this.baseMapper.insertStation(BeanCopyUtils.copyProperties(param, Station.class));
                return true;
            } else {
                log.error("站点已存在");
                return false;
            }
        } else {
            log.error("站点添加错误");
            return false;
        }
    }

    /**
     * @param param
     * @return
     * 根据id删除站点信息
     */
    @Override
    public FrankResult<Boolean> deleteStation(StationDeleteParam param) {
        if (null != param.getId()) {
            this.baseMapper.delete(new LambdaQueryWrapper<Station>().eq(Station::getId, param.getId()));
            return FrankResult.success(Boolean.TRUE);
        } else {
            log.error("站点错误");
            return FrankResult.fail("200","站点有误");
        }
    }

    @Override
    public FrankResult<Boolean> updateStation(StationUpdateParam param) {
        if (!StringUtils.isBlank(param.getName())) {
            Station station = this.getOne(new LambdaQueryWrapper<Station>().eq(Station::getId, param.getId()));
            if (null == station) {
                log.error("站点不存在");
                return FrankResult.fail("200","站点有误，请重新检查");
            } else {
                this.update(BeanCopyUtils.copyProperties(param, Station.class), new LambdaQueryWrapper<Station>().eq(Station::getId, param.getId()));
                return FrankResult.success(Boolean.TRUE);
            }
        } else {
            log.error("站点修改错误");
            return FrankResult.fail("200","站点名不能为空");
        }
    }

    @Override
    public FrankResult<FrankPageAble<Station>> pageData(StationPageParam param) {
        if (null == param.getCurrentPage()) {
            param.setCurrentPage(1);
        }
        if (null == param.getRowsOfPage()) {
            param.setRowsOfPage(10);
        }
        FrankPageInfo pageInfo = new FrankPageInfo(param.getCurrentPage(), param.getRowsOfPage());
        Page<Station> page = new Page<>(param.getCurrentPage(), param.getRowsOfPage());

        if (null != param.getName()) {
            this.baseMapper.selectPage(page, new LambdaQueryWrapper<Station>().eq(Station::getName, param.getName()));
        }
        if (null != param.getLine()) {
            this.baseMapper.selectPage(page, new LambdaQueryWrapper<Station>().eq(Station::getLine, param.getLine()));
        } else {
            this.baseMapper.selectPage(page, null);
        }

        FrankPageAble<Station> pageAble = new FrankPageAble(page.getRecords(), pageInfo, page.getTotal());
        return FrankResult.success(pageAble);
    }

    @Override
    public FrankResult<Boolean> setRatio(String stationName, double ratio) {
        //如果同名站点有多个 即同时经过多条线路 则判定为换乘站（先屏蔽非同城情况）
        if (this.baseMapper.selectCount(new LambdaQueryWrapper<Station>().eq(Station::getName, stationName)) > 1) {
            List<Station> list = this.baseMapper.selectList(new LambdaQueryWrapper<Station>().eq(Station::getName, stationName));
            for (Station station : list) {
                station.setRatio(ratio);
            }
            this.updateBatchById(list);
            return FrankResult.success(Boolean.TRUE);
        } else {
            log.error("该站点非换乘站，无法设置换乘阻抗系数!");
            return FrankResult.fail("200", "该站点非换乘站，无法设置换乘阻抗系数");
        }
    }

//    @Override
//    public List<StationInRoute> listStationInRoute() {
//        List<Station> stations = this.list();
//        List<StationInRoute> stationInRoutes = new ArrayList<>();
//        stationInRoutes.add(BeanCopyUtils.copyProperties(stations.get(0), StationInRoute.class));
//        for (int i = 1; i < stations.size(); i++) {
//            for (int j = 0; j < stationInRoutes.size(); j++) {
//                //如果站点同名且station.get(i)所在线路不存在于stationInRoutes.get(j)时
//                if (stationInRoutes.get(j).getName().equals(stations.get(i).getName()) && !stationInRoutes.get(j).getLine().contains(stations.get(i).getLine())) {
//                    //将原先的List取出来 添加新的元素在重新设List
//                    List<String> tempList = stationInRoutes.get(j).getLine();
//                    tempList.add(stations.get(i).getLine());
//                    stationInRoutes.get(j).setLine(tempList);
//                } else {
//                    //如果没有同名站点，就将station.get(i)存入stationInRoutes总
//                    StationInRoute stationInRoute = BeanCopyUtils.copyProperties(stations.get(i), StationInRoute.class);
//                    List<String> tempList = new ArrayList<>();
//                    tempList.add(stations.get(i).getLine());
//                    stationInRoute.setLine(tempList);
//                    stationInRoutes.add(stationInRoute);
//                }
//            }
//        }
//        return stationInRoutes;
//    }


}
