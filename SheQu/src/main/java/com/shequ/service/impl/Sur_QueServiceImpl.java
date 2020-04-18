package com.shequ.service.impl;

import com.shequ.mapper.Sur_QueMapper;
import com.shequ.pojo.Sur_Que;
import com.shequ.service.Sur_QueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Sur_QueServiceImpl implements Sur_QueService {
    @Autowired
    Sur_QueMapper sur_queMapper;

    @Override
    public List<Sur_Que> findAllSur_Que() {
        return sur_queMapper.findAllSur_Que();
    }

    @Override
    public List<Sur_Que> findAllSur_QueByPage(int satrt, int pagesize) {
        return sur_queMapper.findAllSur_QueByPage(satrt, pagesize);
    }

    @Override
    public int insertSur_Que(Map map) {
        return sur_queMapper.insertSur_Que(map);
    }

    @Override
    public int deleteSur_QueById(int id) {
        return sur_queMapper.deleteSur_QueById(id);
    }

    @Override
    public int updateSur_QueById(Map map) {
        return sur_queMapper.updateSur_QueById(map);
    }
}
