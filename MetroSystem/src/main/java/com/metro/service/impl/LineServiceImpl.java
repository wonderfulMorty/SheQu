package com.metro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.metro.mapper.LineMapper;
import com.metro.param.line.*;
import com.metro.pojo.FrankResult;
import com.metro.pojo.Line;
import com.metro.pojo.Station;
import com.metro.pojo.frank.FrankPageAble;
import com.metro.pojo.frank.FrankPageInfo;
import com.metro.result.LineResult;
import com.metro.service.LineService;
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
        Line line = this.getOne(new LambdaQueryWrapper<Line>().eq(Line::getName, param.getName()));
        if (line == null) {
            this.save(BeanCopyUtils.copyProperties(param, Line.class));
            return true;
        } else {
            log.error("线路已存在");
            return false;
        }
    }

    /**
     * @param param
     * @return
     * 删除线路信息
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
     * 编辑线路信息
     */
    @Override
    public Boolean updateLine(LineUpdateParam param) {
        if (!StringUtils.isBlank(param.getId())) {
            Line line = this.getOne(new LambdaQueryWrapper<Line>().eq(Line::getId, param.getId()));
            if (null == line) {
                log.error("线路不存在");
                return false;
            }
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
            result = this.getBaseMapper().selectPage(page, new LambdaQueryWrapper<Line>().eq(Line::getCity, "深圳市"));
        } else {
            result = this.getBaseMapper().selectPage(page, new LambdaQueryWrapper<Line>().eq(Line::getCity, param.getCity()));
        }
        return FrankResult.success(new FrankPageAble<>(result.getRecords(), new FrankPageInfo(param.getCurrentPage(), param.getRowsOfPage()), result.getTotal()));
    }

    @Override
    public FrankResult getLine(LineGetParam param) {
        Line line = this.getBaseMapper().selectOne(new QueryWrapper<Line>().eq("id", param.getId()));
        LineResult lineResult = new LineResult();
        lineResult = BeanCopyUtils.copyProperties(line, LineResult.class);
        return FrankResult.success(lineResult);
    }

    /**
     * @param lineName
     * @param beginStation
     * @return
     * 更新线路的起始站
     */
    @Override
    public Boolean updateBeginStation(String lineName, String beginStation) {
        Line line = this.getBaseMapper().selectOne(new LambdaQueryWrapper<Line>().eq(Line::getName, lineName));
        line.setBeginStation(beginStation);
        this.update(line, new LambdaQueryWrapper<Line>().eq(Line::getName, lineName));
        return true;
    }

    /**
     * @param lineName
     * @param endStation
     * @return
     * 更新线路的终点站
     */
    @Override
    public Boolean updateEndStation(String lineName, String endStation) {
        Line line = this.getBaseMapper().selectOne(new LambdaQueryWrapper<Line>().eq(Line::getName, lineName));
        line.setBeginStation(endStation);
        this.update(line, new LambdaQueryWrapper<Line>().eq(Line::getName, lineName));
        return true;
    }

    /**
     * @param lineName
     * @param length
     * 更新线路的长度
     */
    @Override
    public void updateLength(String lineName, Integer length) {
        Line line = this.getBaseMapper().selectOne(new LambdaQueryWrapper<Line>().eq(Line::getName, lineName));
        line.setLength(length);
    }

    /**
     * @param lineName
     * @return
     * 获取线路的长度
     */
    @Override
    public Integer getLength(String lineName) {
        return this.getBaseMapper().selectOne(new LambdaQueryWrapper<Line>().eq(Line::getName, lineName)).getLength();
    }

    /**
     * @param start
     * @param end
     * @return
     * 判断是否为直达路线
     */
    @Override
    public List getSameLines(Station start, Station end) {
        List<String> lines = new ArrayList<>();
        for (String line : start.getLine()) {
            if (end.getLine().contains(line)) {
                lines.add(line);
            }
        }
        return lines;
    }


}
