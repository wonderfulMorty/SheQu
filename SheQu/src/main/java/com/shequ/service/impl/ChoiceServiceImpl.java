package com.shequ.service.impl;

import com.shequ.mapper.ChoiceMapper;
import com.shequ.pojo.Choice;
import com.shequ.service.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ChoiceServiceImpl implements ChoiceService {
    @Autowired
    ChoiceMapper choiceMapper;


    @Override
    public List<Choice> findOptOfQue(int qid) {
        return choiceMapper.findOptOfQue(qid);
    }

    @Override
    public int insertUserSurveyOpt(Map map) {
        return choiceMapper.insertUserSurveyOpt(map);
    }

    @Override
    public List<Choice> findUserQueAndOpt(String uid) {
        return choiceMapper.findUserQueAndOpt(uid);
    }

    @Override
    public List<Choice> findAllChoice() {
        return choiceMapper.findAllChoice();
    }

    @Override
    public List<Choice> findAllChoiceByPage(int satrt, int pagesize) {
        return choiceMapper.findAllChoiceByPage(satrt, pagesize);
    }

    @Override
    public int insertChoice(Map map) {
        return choiceMapper.insertChoice(map);
    }

    @Override
    public int deleteChoiceById(int id) {
        return choiceMapper.deleteChoiceById(id);
    }

    @Override
    public int updateChoiceById(Map map) {
        return choiceMapper.updateChoiceById(map);
    }

    @Override
    public List<Choice> findAllUserSurQueAndOpt() {
        return choiceMapper.findAllUserSurQueAndOpt();
    }

    @Override
    public List<Choice> findAllUserSurQueAndOptByPage(int satrt, int pagesize) {
        return choiceMapper.findAllUserSurQueAndOptByPage(satrt, pagesize);
    }
}
