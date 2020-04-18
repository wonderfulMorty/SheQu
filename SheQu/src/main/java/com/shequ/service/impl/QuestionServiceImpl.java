package com.shequ.service.impl;

import com.shequ.mapper.QuestionMapper;
import com.shequ.pojo.Question;
import com.shequ.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class QuestionServiceImpl implements  QuestionService{
    @Autowired
    QuestionMapper questionMapper;

    @Override
    public List<Question> findAllQuestion(int su_id) {
        return questionMapper.findAllQuestion(su_id);
    }

    @Override
    public List<Question> findAllQuestions() {
        return questionMapper.findAllQuestions();
    }

    @Override
    public List<Question> findAllQuestionsByPage(int satrt, int pagesize) {
        return questionMapper.findAllQuestionsByPage(satrt,pagesize);
    }

    @Override
    public int insertQuestion(Map map) {
        return questionMapper.insertQuestion(map);
    }

    @Override
    public int deleteQuestionById(int id) {
        return questionMapper.deleteQuestionById(id);
    }

    @Override
    public int updateQuestionById(Map map) {
        return questionMapper.updateQuestionById(map);
    }
}
