package com.shequ.service;

import com.shequ.pojo.Sur_Que;

import java.util.List;
import java.util.Map;

public interface Sur_QueService {
    List<Sur_Que>findAllSur_Que();
    List<Sur_Que>findAllSur_QueByPage(int satrt,int pagesize);
    int insertSur_Que(Map map);
    int deleteSur_QueById(int id);
    int updateSur_QueById(Map map);
}
