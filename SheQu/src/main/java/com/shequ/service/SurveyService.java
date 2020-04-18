package com.shequ.service;

import com.shequ.pojo.Message;
import com.shequ.pojo.Survey;

import java.util.List;
import java.util.Map;

public interface SurveyService {
    List<Survey>findAllSurvey();
    int insertUserSurvey(Map map);
    List<String> findAllSurveyByUid(String uid);
    List<Survey>findAllSurveyByPage(int satrt,int pagesize);
    int insertSurvey(Map map);
    int deleteSurveyById(int id);
    int updateSurveyById(Map map);
}
