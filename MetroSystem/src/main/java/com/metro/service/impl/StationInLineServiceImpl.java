package com.metro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.metro.mapper.StationInLineMapper;
import com.metro.param.stationInLine.*;
import com.metro.pojo.FrankResult;
import com.metro.pojo.Line;
import com.metro.pojo.Station;
import com.metro.pojo.StationInLine;
import com.metro.pojo.frank.FrankPageAble;
import com.metro.pojo.frank.FrankPageInfo;
import com.metro.service.LineService;
import com.metro.service.StationInLineService;
import com.metro.util.BeanCopyUtils;
import com.metro.util.StringUtils;
import com.sun.org.apache.xpath.internal.operations.Bool;
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
public class StationInLineServiceImpl extends ServiceImpl<StationInLineMapper, StationInLine> implements StationInLineService {

    @Autowired
    StationInLineMapper stationInLineMapper;

    @Autowired
    LineService lineService;

    /**
     * @param param
     * @return
     * 新增线路站点信息
     */
    @Override
    public FrankResult<Boolean> addStationInLine(StationInLineAddParam param) {
        if (null == param.getLineOrder()) {
            log.error("站点次序错误");
            return FrankResult.fail("","站点次序有误,添加失败");
        }
        if (null == param.getLine()) {
            log.error("线路错误");
            return FrankResult.fail("","线路获取失败，添加失败");
        }
        if (null == param.getStation()) {
            log.error("站点错误");
            return FrankResult.fail("","站点获取失败,添加失败");
        }
        StationInLine stationInLine = new StationInLine();
        Integer order = param.getLineOrder();

        if ((param.getLineOrder() - 1) > this.baseMapper.selectList(new LambdaQueryWrapper<StationInLine>().eq(StationInLine::getLineName, param.getLine().getName())).size() || param.getLineOrder() <= 0) {
            log.error("站点次序有误，请重新确认");
            return FrankResult.fail("","站点次序有误,添加失败");
        }

        List<StationInLine> list = this.list(new LambdaQueryWrapper<StationInLine>().eq(StationInLine::getLineName, param.getLine().getName()));

        list.stream().forEach(e->{

            //将插入的新站点的次序后的站点的次序依次往后+1
            if (e.getLineOrder() >= order) {
                //如果新加入的站点是起始站，原先的起始站标记被删除
                if (order == 1 && e.getLineOrder() == 1) {
                    e.setIsBeginStation(0);
                } else if (order == (list.size() + 1) && e.getLineOrder() == list.size()) {
                    //如果新加入的站点是终点站，原先的终点站标记被删除
                    e.setIsEndStation(0);
                }
                e.setLineOrder(e.getLineOrder() + 1);
            }
            //修改过的次序如果是新添加站点的前一站
            if (e.getLineOrder() == order - 1) {
                e.setTimeToNxt(param.getTimeToPre());
            }
            //修改过的次序如果是新添加站点的后一站
            if (e.getLineOrder() == order + 1) {
                e.setTimeToPre(param.getTimeToNxt());
            }
            if (list.size() == 1) {
                e.setIsEndStation(1);
                e.setIsBeginStation(1);
            }
        });

        //将信息存入到线路中的站点信息中
        stationInLine.setLineName(param.getLine().getName());
        stationInLine.setCity(param.getLine().getCity());
        stationInLine.setCityCode(param.getLine().getCityCode());
        stationInLine.setLineOrder(order);
        if (order == 1) {
            //如果次序为1，则设为起始站
            stationInLine.setIsBeginStation(1);
            stationInLine.setIsEndStation(0);
            lineService.updateBeginStation(stationInLine.getLineName(), stationInLine.getName());
        } else if (order == list.size() + 1) {
            //如果次序为原size+1，则设为终点站
            stationInLine.setIsBeginStation(0);
            stationInLine.setIsEndStation(1);
            lineService.updateEndStation(stationInLine.getLineName(), stationInLine.getName());
        } else {
            stationInLine.setIsBeginStation(0);
            stationInLine.setIsEndStation(0);
        }
        stationInLine.setName(param.getStation().getName());
        stationInLine.setTimeToNxt(param.getTimeToNxt());
        stationInLine.setTimeToPre(param.getTimeToPre());

        list.add(stationInLine);
        this.saveOrUpdateBatch(list);
        return FrankResult.success(Boolean.TRUE);
    }

    /**
     * 删除线路中的站点信息
     * @param param
     * @return
     */
    @Override
    public FrankResult<Boolean> deleteStationInLine(StationInLineDeleteParam param) {
        if (null == param.getOrder()) {
            log.error("站点次序错误，删除失败");
            return FrankResult.fail("","站点次序失败，删除错误");
        }
        if (null == param.getLine()) {
            log.error("线路错误,删除失败");
            return FrankResult.fail("","线路获取失败，删除错误");
        }
        if (null == param.getStation()) {
            log.error("站点错误，删除失败");
            return FrankResult.fail("","站点获取失败，删除错误");
        }
        //如果返回值为false，即删除失败
        if (!this.remove(new LambdaQueryWrapper<StationInLine>().eq(StationInLine::getLineName, param.getLine().getName())
                .eq(StationInLine::getName, param.getStation().getName())
                .eq(StationInLine::getLineOrder, param.getOrder()))) {
            log.error("删除失败");
            return FrankResult.fail("","数据删除失败");
        }
        Integer order = param.getOrder();
        List<StationInLine> list = this.baseMapper.selectList(new LambdaQueryWrapper<StationInLine>().eq(StationInLine::getLineName, param.getLine().getName()));
        list.stream().forEach(e->{
            //将删除站点后的站点的次序都-1
            if (e.getLineOrder() > order) {
                e.setLineOrder(e.getLineOrder() - 1);
            }
            //如果删除的是起始站，则后一个站点设为起始站
            if (order == 1 && e.getLineOrder() == 1) {
                e.setIsBeginStation(1);
            }
            //如果删除的是终点站，则后一个站点设为终点站
            //此处的list.size是已经删除了站点后的size，所以如果删除站点为终点站的话，次序应为size+1
            if (order == list.size() + 1 && e.getLineOrder() == list.size()) {
                e.setIsEndStation(1);
            }
        });

        //需注意，此处并没有修改到因站点变更产生变化的影响的上一站和下一站的时间

        this.saveOrUpdateBatch(list);
        return FrankResult.success(Boolean.TRUE);
    }

    /**
     * @param param
     * @return
     * 因为涉及到次序修改，因此选择进行批量修改
     */
    @Override
    public FrankResult<Boolean> updateStationInLine(StationInLineUpdateListParam param) {

        if (null == param.getList()) {
            log.error("更新错误，请检查更新数据格式");
            return FrankResult.fail("", "更新数据获取失败");
        }
        List<StationInLine> list = new ArrayList<>();
        param.getList().stream().forEach(e->{
            if (e.getLineOrder() == 1) {
                e.setIsBeginStation(1);
                e.setIsEndStation(0);
                lineService.updateBeginStation(e.getLineName(), e.getName());
            } else if (e.getLineOrder() == list.size()) {
                e.setIsBeginStation(0);
                e.setIsEndStation(1);
                lineService.updateEndStation(e.getLineName(), e.getName());
            } else {
                e.setIsBeginStation(0);
                e.setIsEndStation(0);
            }
            list.add(BeanCopyUtils.copyProperties(e, StationInLine.class));
        });
        this.saveOrUpdateBatch(list);
        return FrankResult.success(Boolean.TRUE);
    }

    /**
     * @param param
     * @return
     * 分页查询数据
     */
    @Override
    public FrankResult<FrankPageAble<StationInLine>> pageData(StationInLinePageParam param) {
        if (null == param.getCurrentPage()) {
            param.setCurrentPage(1);
        }
        if (null == param.getRowsOfPage()) {
            param.setRowsOfPage(10);
        }
        FrankPageInfo pageInfo = new FrankPageInfo((param.getCurrentPage()), param.getRowsOfPage());
        Page<StationInLine> page = new Page<>(param.getCurrentPage(), param.getRowsOfPage());

        if (null == param.getLineName()) {
            this.baseMapper.selectPage(page, null);
        } else {
            this.baseMapper.selectPage(page, new LambdaQueryWrapper<StationInLine>().eq(StationInLine::getLineName, param.getLineName()));
        }

        FrankPageAble<StationInLine> pageAble = new FrankPageAble(page.getRecords(), pageInfo, page.getTotal());
        return FrankResult.success(pageAble);
    }
}
