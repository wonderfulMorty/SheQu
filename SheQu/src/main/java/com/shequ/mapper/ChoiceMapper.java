package com.shequ.mapper;

import com.shequ.pojo.Choice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ChoiceMapper {
  List<Choice> findOptOfQue(int qid);
  int insertUserSurveyOpt(Map map);
  List<Choice> findUserQueAndOpt(String uid);
  List<Choice>findAllChoice();
  List<Choice>findAllChoiceByPage(int satrt,int pagesize);
  int insertChoice(Map map);
  int deleteChoiceById(int id);
  int updateChoiceById(Map map);
  List<Choice>findAllUserSurQueAndOpt();
  List<Choice>findAllUserSurQueAndOptByPage(int satrt,int pagesize);
}
