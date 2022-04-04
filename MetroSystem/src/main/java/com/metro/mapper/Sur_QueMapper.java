package com.metro.mapper;

import com.metro.pojo.Sur_Que;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface Sur_QueMapper {
  List<Sur_Que>findAllSur_Que();
  List<Sur_Que>findAllSur_QueByPage(int satrt,int pagesize);
  int insertSur_Que(Map map);
  int deleteSur_QueById(int id);
  int updateSur_QueById(Map map);
}
