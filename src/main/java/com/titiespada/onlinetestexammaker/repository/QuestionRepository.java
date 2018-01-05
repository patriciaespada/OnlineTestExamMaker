package com.titiespada.onlinetestexammaker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.titiespada.onlinetestexammaker.model.Question;

public interface QuestionRepository extends CrudRepository<Question, Integer> {

    @Query("SELECT q FROM Question q, QuestionTestExam qte WHERE qte.testExam.id = :id AND qte.question.id = q.id ORDER BY qte.order ASC")
	public List<Question> findByTestExamId(@Param("id") Integer id);
    
}
