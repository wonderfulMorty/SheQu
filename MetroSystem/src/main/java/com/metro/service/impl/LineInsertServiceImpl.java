package com.metro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.metro.param.line.LineGetParam;
import com.metro.param.line.LineInsert;
import com.metro.pojo.*;
import com.metro.result.LineResult;
import com.metro.service.LineInsertService;
import com.metro.service.LineService;
import com.metro.service.StationService;
import com.metro.util.BeanCopyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/4/5
 * @Content:
 */
@Service
public class LineInsertServiceImpl implements LineInsertService {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    LineService lineService;

    @Autowired
    StationService stationService;


    /**
     * @param param
     * @return
     * 获取单条线路信息
     */
    @Override
    public LineResult getLine(LineGetParam param) {
        Line line = lineService.getBaseMapper().selectOne(new QueryWrapper<Line>().eq("id", param.getId()));
        LineResult lineResult = new LineResult();
        lineResult = BeanCopyUtils.copyProperties(line, LineResult.class);
        return lineResult;
    }

    /**
     * @param lineName
     * @return
     * 根据线路名去收集站点
     */
    @Override
    public List<String> selectStations(String lineName) {

        List<Station> stations = stationService.list(new LambdaQueryWrapper<Station>().eq(Station::getLine, lineName));
        //根据站点的顺序从小到大进行重新排序
//        stations.sort(Station.Comparators.LINEORDER);
        stations.sort(Comparator.comparing(Station::getLineOrder));
        List<String> list = new ArrayList<>();
        //将符合条件的站点加入list
        for (Station station : stations) {
            list.add(station.getName());
        }
        return list;
    }

    /**
     * @param
     * @return
     * 返回所有line并完成LineInsert的组装
     */
    @Override
    public List<LineInsert> selectLineInsertAll() {

        List<LineInsert> lineInsertList = new ArrayList<>();
        List<Line> lineList = lineService.list();
        //获取所有线路信息，根据这些线路信息的线路名将符合条件的站点list插入对应的LineIseet
        for (Line line : lineList) {
            LineInsert lineInsert = BeanCopyUtils.copyProperties(line, LineInsert.class);
            lineInsert.setStation(this.selectStations(line.getName()));
            lineInsertList.add(lineInsert);
        }
        return lineInsertList;

    }

    public LineInsert selectLineInsert(String lineName) {
        List<LineInsert> lineInsertList = this.selectLineInsertAll();
        for (LineInsert lineInsert : lineInsertList) {
            if (lineInsert.getName().equals(lineName)) {
                return lineInsert;
            }
        }
        return null;
    }
    /**
     * @param lineName
     * @return
     * 获取线路的长度
     */
    @Override
    public Integer getLength(String lineName) {
        List<LineInsert> lineInsertList = this.selectLineInsertAll();
        for (LineInsert lineInsert : lineInsertList) {
            //如果查的到线路，则返回线路的station.size() 没有则返回null
            if (lineInsert.getName().equals(lineName)) {
                return lineInsert.getStation().size();
            }
        }
        return null;
    }


    /**
     * @param lineName
     * @return
     * 获取线路的起始站和终点站
     */
    @Override
    public LineStartAndEnd getStartEnd(String lineName) {
        LineStartAndEnd startAndEnd = new LineStartAndEnd();
        List<LineInsert> lineInsertList = this.selectLineInsertAll();
        for (LineInsert lineInsert : lineInsertList) {
            //如果查的到线路，则返回线路的station.size() 没有则返回null
            if (lineInsert.getName().equals(lineName)) {
                if (lineInsert.getStation().size() == 0) {
                    logger.error("该线路总暂无站点");
                    return null;
                }
                //list的第一个元素和第二个元素分别是起始站和终点站
                startAndEnd.setStart(lineInsert.getStation().get(0));
                startAndEnd.setEnd(lineInsert.getStation().get(lineInsert.getStation().size() - 1));
            }
        }
        return startAndEnd;
    }

    /**
     * @param start
     * @param end
     * @return
     * 判断是否为直达路线
     */
    @Override
    public List getSameLines(StationInRoute start, StationInRoute end) {
        List<String> lines = new ArrayList<>();
        for (String line : start.getLine()) {
            if (end.getLine().contains(line)) {
                lines.add(line);
            }
        }
        return lines;
    }

}
