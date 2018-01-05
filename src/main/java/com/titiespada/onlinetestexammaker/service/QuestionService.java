package com.titiespada.onlinetestexammaker.service;

import java.util.List;

import com.titiespada.onlinetestexammaker.model.Question;

public interface QuestionService {

	List<Question> findByTestExamId(Integer id);
	
}
