package com.metro.service;

import com.metro.pojo.Repair;

import java.util.List;
import java.util.Map;

public interface RepairService {
    int insertRepair(Map map);
    List<Repair> findAllRepair();
    List<Repair>findAllRepairByPage(int satrt,int pagesize);
}
