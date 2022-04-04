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
import com.metro.pojo.frank.FrankPageAble;
import com.metro.pojo.frank.FrankPageInfo;
import com.metro.service.StationService;
import com.metro.util.BeanCopyUtils;
import com.metro.util.ObjectUtils;
import com.metro.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public FrankResult<Boolean> addStation(StationAddParam param) {
        if (null != param.getName()) {
            Station station = this.getOne(new LambdaQueryWrapper<Station>().eq(Station::getName, param.getName()));
            if (null == station) {
                this.save(BeanCopyUtils.copyProperties(param, Station.class));
                return FrankResult.success(Boolean.TRUE);
            } else {
                log.error("站点已存在");
                return  FrankResult.fail("","");
            }
        } else {
            log.error("站点添加错误");
            return  FrankResult.fail("","");
        }
    }

    @Override
    public FrankResult<Boolean> deleteStation(StationDeleteParam param) {
        if (null != param.getId()) {
            this.baseMapper.delete(new LambdaQueryWrapper<Station>().eq(Station::getId, param.getId()));
            return FrankResult.success(Boolean.TRUE);
        } else {
            log.error("站点错误");
            return FrankResult.fail("","");
        }
    }

    @Override
    public FrankResult<Boolean> updateStation(StationUpdateParam param) {
        if (!StringUtils.isBlank(param.getName())) {
            Station station = this.getOne(new LambdaQueryWrapper<Station>().eq(Station::getId, param.getId()));
            if (null == station) {
                log.error("站点不存在");
                return FrankResult.fail("","");
            } else {
                this.saveOrUpdate(BeanCopyUtils.copyProperties(param, Station.class), new LambdaQueryWrapper<Station>().eq(Station::getId, param.getId()));
                return FrankResult.success(Boolean.TRUE);
            }
        } else {
            log.error("站点修改错误");
            return FrankResult.fail("","");
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
        } else {
            this.baseMapper.selectPage(page, null);
        }

        FrankPageAble<Station> pageAble = new FrankPageAble(page.getRecords(), pageInfo, page.getTotal());
        return FrankResult.success(pageAble);
    }


}
