package com.shequ.service;

import com.shequ.pojo.Pay;

import java.util.List;
import java.util.Map;

public interface PayService {
    int insertPayment(Map map);
    List<Pay> findPayByUid(String uid);
    List<Pay> findAllPay();
    List<Pay>findAllPayByPage(int satrt, int pagesize);
}
