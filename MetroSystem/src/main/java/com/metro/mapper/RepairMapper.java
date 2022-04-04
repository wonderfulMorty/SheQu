package com.metro.mapper;

import com.metro.pojo.Repair;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RepairMapper {
    int insertRepair(Map map);
    List<Repair> findAllRepair();
    List<Repair>findAllRepairByPage(int satrt,int pagesize);
}
