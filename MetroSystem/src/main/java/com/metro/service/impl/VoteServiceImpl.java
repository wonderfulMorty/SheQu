package com.metro.service.impl;

import com.metro.mapper.VoteMapper;
import com.metro.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class VoteServiceImpl implements VoteService {
    @Autowired
    VoteMapper voteMapper;

    @Override
    public int insertVote(Map map) {
        return voteMapper.insertVote(map);
    }
}
