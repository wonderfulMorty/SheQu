package com.shequ.mapper;

import com.shequ.pojo.Pay;
import com.shequ.pojo.Survey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PayMapper {
    int insertPayment(Map map);
    List<Pay> findPayByUid(String uid);
    List<Pay> findAllPay();
    List<Pay>findAllPayByPage(int satrt, int pagesize);
}
