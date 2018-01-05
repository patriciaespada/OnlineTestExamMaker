package com.titiespada.onlinetestexammaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.titiespada.onlinetestexammaker.model.TestExam;
import com.titiespada.onlinetestexammaker.repository.TestExamRepository;

@Service("testExamService")
public class TestExamServiceImpl implements TestExamService {

	@Autowired
	private TestExamRepository testExamRepository;
	
	public TestExam findById(Integer id) {
		return testExamRepository.findOne(id);
	}

	public List<TestExam> findAll() {
		return (List<TestExam>) testExamRepository.findAll();
	}

}
