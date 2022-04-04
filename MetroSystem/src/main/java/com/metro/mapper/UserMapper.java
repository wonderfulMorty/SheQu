package com.metro.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserMapper {
   int insertUser(Map map);
   String findUidByPNumAndPwd(Map map);
}
