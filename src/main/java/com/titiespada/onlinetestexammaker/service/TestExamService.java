package com.titiespada.onlinetestexammaker.service;

import java.util.List;

import com.titiespada.onlinetestexammaker.model.TestExam;

public interface TestExamService {

    TestExam findById(Integer id);
    List<TestExam> findAll(); 

}
