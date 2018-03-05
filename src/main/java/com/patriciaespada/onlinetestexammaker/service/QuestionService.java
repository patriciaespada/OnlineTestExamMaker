package com.patriciaespada.onlinetestexammaker.service;

import java.util.List;

import com.patriciaespada.onlinetestexammaker.model.Question;

public interface QuestionService {

	List<Question> findByTestExamId(Integer id);
	
}
