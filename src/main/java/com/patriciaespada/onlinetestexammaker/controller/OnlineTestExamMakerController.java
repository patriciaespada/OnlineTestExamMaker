package com.patriciaespada.onlinetestexammaker.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.patriciaespada.onlinetestexammaker.dto.QuestionChoiceAnswerDto;
import com.patriciaespada.onlinetestexammaker.dto.QuestionDto;
import com.patriciaespada.onlinetestexammaker.dto.TestExamDto;
import com.patriciaespada.onlinetestexammaker.model.Question;
import com.patriciaespada.onlinetestexammaker.model.QuestionChoiceAnswer;
import com.patriciaespada.onlinetestexammaker.model.QuestionTestExam;
import com.patriciaespada.onlinetestexammaker.model.TestExam;
import com.patriciaespada.onlinetestexammaker.service.QuestionService;
import com.patriciaespada.onlinetestexammaker.service.TestExamService;

@RestController
public class OnlineTestExamMakerController {
	
	private static final Logger logger = Logger.getLogger(OnlineTestExamMakerController.class);

	@Autowired
	private TestExamService testExamService;
	
	@Autowired
	private QuestionService questionService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody String greetings() {
		return "Hello World!";
	}

	@RequestMapping(value = "/testExam/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TestExamDto> findTestExamById(@PathVariable(value="id") Integer id) {
		logger.debug("Fetching TestExam with id " + id);
		
		TestExam testExam = testExamService.findById(id);
		if (testExam == null) {
			logger.debug("TestExam with id " + id + " not found");
			return new ResponseEntity<TestExamDto>(HttpStatus.NOT_FOUND);
		}
		
		TestExamDto testExamDto = TestExamDto.createTestExamDto(testExam);
		
		return new ResponseEntity<TestExamDto>(testExamDto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/testExam", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TestExamDto>> findTestExams() {
		List<TestExam> testExam = testExamService.findAll();
		if (testExam == null) {
			logger.debug("Could not found any TestExams");
			return new ResponseEntity<List<TestExamDto>>(HttpStatus.NOT_FOUND);
		}
		
		
		List<TestExamDto> testExamDtoList = testExam.stream().map(TestExamDto::createTestExamDto).collect(Collectors.toList());
		
		return new ResponseEntity<List<TestExamDto>>(testExamDtoList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/testExam/{id}/question", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<QuestionDto>> findQuestionByTestExamId(@PathVariable(value="id") Integer id) {
		List<Question> questions = questionService.findByTestExamId(id);
		if (questions == null) {
			logger.debug("There are no questions for the TestExam with id " + id);
			return new ResponseEntity<List<QuestionDto>>(HttpStatus.NOT_FOUND);
		}
		
		List<QuestionDto> questionDtoList = new ArrayList<>(questions.size());
		for (int i = 0; i < questions.size(); i++) {
			Question question = questions.get(i);
			
			List<QuestionChoiceAnswerDto> questionChoiceAnswerDtoList = 
					question.getQuestionChoiceAnswers().stream()
					.map(QuestionChoiceAnswerDto::createQuestionChoiceAnswerDto)
					.collect(Collectors.toList());
			
			questionDtoList.add(QuestionDto.createQuestionDto(question, i+1, questionChoiceAnswerDtoList));
		}
		
		return new ResponseEntity<List<QuestionDto>>(questionDtoList, HttpStatus.OK);
	}
	
	
}
