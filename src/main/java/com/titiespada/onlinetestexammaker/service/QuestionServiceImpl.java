package com.titiespada.onlinetestexammaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.titiespada.onlinetestexammaker.model.Question;
import com.titiespada.onlinetestexammaker.repository.QuestionRepository;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public List<Question> findByTestExamId(Integer id) {
		return questionRepository.findByTestExamId(id);
	}

}
