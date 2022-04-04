package com.metro.service;

import com.metro.pojo.Pay;

import java.util.List;
import java.util.Map;

public interface PayService {
    int insertPayment(Map map);
    List<Pay> findPayByUid(String uid);
    List<Pay> findAllPay();
    List<Pay>findAllPayByPage(int satrt, int pagesize);
}
