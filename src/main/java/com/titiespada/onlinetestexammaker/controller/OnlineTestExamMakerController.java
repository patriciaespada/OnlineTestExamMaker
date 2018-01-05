package com.titiespada.onlinetestexammaker.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.titiespada.onlinetestexammaker.dto.TestExamDto;
import com.titiespada.onlinetestexammaker.model.TestExam;
import com.titiespada.onlinetestexammaker.service.TestExamService;

@RestController
public class OnlineTestExamMakerController {
	
	private static final Logger logger = Logger.getLogger(OnlineTestExamMakerController.class);

	@Autowired
	private TestExamService testExamService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody String greetings() {
		return "Hello World!";
	}

	@RequestMapping(value = "/testExam", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TestExamDto> findTestExamById(@RequestParam(value="id") Integer id) {
		logger.debug("Fetching TestExam with id " + id);
		
		TestExam testExam = testExamService.findById(id);
		if (testExam == null) {
			logger.debug("TestExam with id " + id + " not found");
			return new ResponseEntity<TestExamDto>(HttpStatus.NOT_FOUND);
		}
		
		TestExamDto testExamDto = TestExamDto.createTestExamDto(testExam);
		
		return new ResponseEntity<TestExamDto>(testExamDto, HttpStatus.OK);
	}
}
