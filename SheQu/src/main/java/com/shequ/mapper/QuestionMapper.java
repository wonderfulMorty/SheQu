package com.shequ.mapper;

import com.shequ.pojo.Choice;
import com.shequ.pojo.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface QuestionMapper {
  List<Question> findAllQuestion(int su_id);
  List<Question>findAllQuestions();
  List<Question>findAllQuestionsByPage(int satrt,int pagesize);
  int insertQuestion(Map map);
  int deleteQuestionById(int id);
  int updateQuestionById(Map map);
}
