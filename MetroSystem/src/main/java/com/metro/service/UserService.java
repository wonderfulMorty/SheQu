package com.metro.service;

import java.util.Map;

public interface UserService {
    int insertUser(Map map);
    String findUidByPNumAndPwd(Map map);
}
