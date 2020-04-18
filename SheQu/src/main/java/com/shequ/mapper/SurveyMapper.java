package com.shequ.mapper;

import com.shequ.pojo.Message;
import com.shequ.pojo.Survey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SurveyMapper {
  List<Survey>findAllSurvey();
  int insertUserSurvey(Map map);
  List<String> findAllSurveyByUid(String uid);
  List<Survey>findAllSurveyByPage(int satrt,int pagesize);
  int insertSurvey(Map map);
  int deleteSurveyById(int id);
  int updateSurveyById(Map map);
}
