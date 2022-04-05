package com.metro.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.metro.param.line.LineInsert;
import com.metro.param.lineInsert.LineInsertPageParam;
import com.metro.pojo.FrankResult;
import com.metro.pojo.LineStartAndEnd;
import com.metro.pojo.frank.FrankPageAble;
import com.metro.service.LineInsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/4/5
 * @Content:
 */
@RestController
@RequestMapping("/lineInsert")
public class LineInsertController {

    @Autowired
    LineInsertService lineInsertService;

    @PostMapping("/findStartAndEnd")
    public FrankResult<LineStartAndEnd> findStartAndEndStation(@RequestParam String lineName) {
        return FrankResult.success(lineInsertService.getStartEnd(lineName));
    }

    @PostMapping("/findLength")
    public FrankResult<Integer> findLength(@RequestParam String lineName) {
        return FrankResult.success(lineInsertService.getLength(lineName));
    }

    @PostMapping("/listAll")
    public FrankResult<List<LineInsert>> listAll() {
        return FrankResult.success(lineInsertService.selectLineInsertAll());
    }

    @PostMapping("/listOne")
    public FrankResult<LineInsert> listOne(@RequestParam String lineName) {
        return FrankResult.success(lineInsertService.selectLineInsert(lineName));
    }
}
