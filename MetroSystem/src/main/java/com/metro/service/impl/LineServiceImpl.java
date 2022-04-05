package com.metro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.metro.mapper.LineMapper;
import com.metro.mapper.StationMapper;
import com.metro.param.line.*;
import com.metro.pojo.FrankResult;
import com.metro.pojo.Line;
import com.metro.pojo.Station;
import com.metro.pojo.StationInRoute;
import com.metro.pojo.frank.FrankPageAble;
import com.metro.pojo.frank.FrankPageInfo;
import com.metro.result.LineResult;
import com.metro.service.LineService;
import com.metro.service.StationService;
import com.metro.util.BeanCopyUtils;
import com.metro.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/3/10
 * @Content:
 */
@Service
public class LineServiceImpl extends ServiceImpl<LineMapper, Line> implements LineService {

    @Autowired
    LineMapper lineMapper;

    @Autowired
    StationService stationService;

    /**
     * @param param
     * @return
     * 新增线路
     */
    @Override
    public Boolean addLine(LineAddParam param) {
        if (null == param.getName()) {
            throw new RuntimeException("线路名不能为空");
        }
        //不允许存在同一城市且同名的线路
        Line line = this.getOne(new LambdaQueryWrapper<Line>().eq(Line::getName, param.getName()).eq(Line::getCity, param.getCity()));
        if (line == null) {
            this.save(BeanCopyUtils.copyProperties(param, Line.class));
            return true;
        } else {
            log.error("线路名已存在，请确认城市或线路名是否正确");
            return false;
        }
    }

    /**
     * @param param
     * @return
     * 根据线路id删除线路信息
     */
    @Override
    public Boolean deleteLine(LineDeleteParam param) {
        if (null == param.getId()) {
            log.error("线路不存在");
            return false;
        }
        this.baseMapper.delete(new LambdaQueryWrapper<Line>().eq(Line::getId, param.getId()));
        return true;
    }

    /**
     * @param param
     * @return
     * 根据id编辑线路信息
     */
    @Override
    public Boolean updateLine(LineUpdateParam param) {
        if (!StringUtils.isBlank(param.getId())) {
            Line line = this.getOne(new LambdaQueryWrapper<Line>().eq(Line::getId, param.getId()));
            if (null == line) {
                log.error("线路不存在");
                return false;
            }
            Line newLine = BeanCopyUtils.copyProperties(param, Line.class);
            this.update(newLine, new LambdaQueryWrapper<Line>().eq(Line::getId, param.getId()));
            return true;
        } else {
            log.error("线路修改错误");
            return false;
        }
    }

    /**
     * @param param
     * @return
     * 分页查询线路
     */
    @Override
    public FrankResult<FrankPageAble<Line>> pageLine(LinePageParam param) {
        IPage<Line> page = new Page<>(param.getCurrentPage(), param.getRowsOfPage());
        IPage<Line> result;
        if (param.getCity() == null) {
            result = this.getBaseMapper().selectPage(page, null);
        } else {
            result = this.getBaseMapper().selectPage(page, new LambdaQueryWrapper<Line>().eq(Line::getCity, param.getCity()));
        }
        return FrankResult.success(new FrankPageAble<>(result.getRecords(), new FrankPageInfo(param.getCurrentPage(), param.getRowsOfPage()), result.getTotal()));
    }

//    /**
//     * @param param
//     * @return
//     * 获取单条线路信息
//     */
//    @Override
//    public FrankResult getLine(LineGetParam param) {
//        Line line = this.getBaseMapper().selectOne(new QueryWrapper<Line>().eq("id", param.getId()));
//        LineResult lineResult = new LineResult();
//        lineResult = BeanCopyUtils.copyProperties(line, LineResult.class);
//        return FrankResult.success(lineResult);
//    }

//    /**
//     * @param lineName
//     * @return
//     * 根据线路名去收集站点
//     */
//    public List<String> selectStations(String lineName) {
//
//        List<Station> stations = stationService.list(new LambdaQueryWrapper<Station>().eq(Station::getLine, lineName));
//        //根据站点的顺序从小到大进行重新排序
//        stations.sort(Station.Comparators.LINEORDER);
//        List<String> list = new ArrayList<>();
//        //将符合条件的站点加入list
//        for (Station station : stations) {
//            list.add(station.getName());
//        }
//        return list;
//    }

//    /**
//     * @param
//     * @return
//     * 完成LineInsert的组装
//     */
//    public List<LineInsert> selectLineInsert() {
//
//        List<LineInsert> lineInsertList = new ArrayList<>();
//        List<Line> lineList = this.list();
//        //获取所有线路信息，根据这些线路信息的线路名将符合条件的站点list插入对应的LineIseet
//        for (Line line : lineList) {
//            LineInsert lineInsert = BeanCopyUtils.copyProperties(line, LineInsert.class);
//            lineInsert.setStation(this.selectStations(line.getName()));
//            lineInsertList.add(lineInsert);
//        }
//        return lineInsertList;
//
//    }



//    /**
//     * @param lineName
//     * @return
//     * 获取线路的长度
//     */
//    @Override
//    public Integer getLength(String lineName) {
//        List<LineInsert> lineInsertList = this.selectLineInsert();
//        for (LineInsert lineInsert : lineInsertList) {
//            //如果查的到线路，则返回线路的station.size() 没有则返回null
//            if (lineInsert.getName().equals(lineName)) {
//                return lineInsert.getStation().size();
//            }
//        }
//        return null;
//    }
//
//
//    /**
//     * @param lineName
//     * @return
//     * 获取线路的起始站和终点站
//     */
//    @Override
//    public List<String> getStartEnd(String lineName) {
//        List<String> list = new ArrayList<>();
//        List<LineInsert> lineInsertList = this.selectLineInsert();
//        for (LineInsert lineInsert : lineInsertList) {
//            //如果查的到线路，则返回线路的station.size() 没有则返回null
//            if (lineInsert.getName().equals(lineName)) {
//                if (lineInsert.getStation().size() == 0) {
//                    log.error("该线路总暂无站点");
//                    return null;
//                }
//                //list的第一个元素和第二个元素分别是起始站和终点站
//                list.add(lineInsert.getStation().get(0));
//                list.add(lineInsert.getStation().get(lineInsert.getStation().size() - 1));
//            }
//        }
//        return list;
//    }




}
