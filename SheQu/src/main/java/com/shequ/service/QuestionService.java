package com.shequ.service;

import com.shequ.pojo.Question;
import com.shequ.pojo.Survey;

import java.util.List;
import java.util.Map;

public interface QuestionService {
    List<Question> findAllQuestion(int su_id);
    List<Question>findAllQuestions();
    List<Question>findAllQuestionsByPage(int satrt,int pagesize);
    int insertQuestion(Map map);
    int deleteQuestionById(int id);
    int updateQuestionById(Map map);
}
