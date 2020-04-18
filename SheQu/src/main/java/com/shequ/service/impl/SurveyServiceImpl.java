package com.shequ.service.impl;

import com.shequ.mapper.SurveyMapper;
import com.shequ.pojo.Survey;
import com.shequ.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SurveyServiceImpl implements SurveyService {
    @Autowired
    SurveyMapper surveyMapper;

    @Override
    public List<Survey> findAllSurvey() {
        return surveyMapper.findAllSurvey();
    }

    @Override
    public int insertUserSurvey(Map map) {
        return surveyMapper.insertUserSurvey(map);
    }

    @Override
    public List<String> findAllSurveyByUid(String uid) {
        return surveyMapper.findAllSurveyByUid(uid);
    }

    @Override
    public List<Survey> findAllSurveyByPage(int satrt, int pagesize) {
        return surveyMapper.findAllSurveyByPage(satrt, pagesize);
    }

    @Override
    public int insertSurvey(Map map) {
        return surveyMapper.insertSurvey(map);
    }

    @Override
    public int deleteSurveyById(int id) {
        return surveyMapper.deleteSurveyById(id);
    }

    @Override
    public int updateSurveyById(Map map) {
        return surveyMapper.updateSurveyById(map);
    }


}
