package com.shequ.service.impl;

import com.shequ.mapper.PayMapper;
import com.shequ.pojo.Pay;
import com.shequ.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PayServiceImpl implements PayService {
    @Autowired
    PayMapper payMapper;


    @Override
    public int insertPayment(Map map) {
        return payMapper.insertPayment(map);
    }

    @Override
    public List<Pay> findPayByUid(String uid) {
        return payMapper.findPayByUid(uid);
    }

    @Override
    public List<Pay> findAllPay() {
        return payMapper.findAllPay();
    }

    @Override
    public List<Pay> findAllPayByPage(int satrt, int pagesize) {
        return payMapper.findAllPayByPage(satrt, pagesize);
    }
}
