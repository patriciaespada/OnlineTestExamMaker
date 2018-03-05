package com.patriciaespada.onlinetestexammaker.service;

import java.util.List;

import com.patriciaespada.onlinetestexammaker.model.TestExam;

public interface TestExamService {

    TestExam findById(Integer id);
    List<TestExam> findAll(); 

}
