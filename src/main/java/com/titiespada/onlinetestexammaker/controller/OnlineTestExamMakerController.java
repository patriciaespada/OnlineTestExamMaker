package com.titiespada.onlinetestexammaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.titiespada.onlinetestexammaker.model.TestExam;
import com.titiespada.onlinetestexammaker.service.TestExamService;

@RestController
public class OnlineTestExamMakerController {

	@Autowired
	private TestExamService testExamService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody String greetings() {
		return "Hello World!";
	}
	
	@RequestMapping(value = "/testExam/", method = RequestMethod.GET)
	public @ResponseBody TestExam findTestExamById(@RequestParam(value="id") Integer id) {
		System.out.println("***************");
		if (id == null) {
			// return error
		}
		return testExamService.findById(id);
	}
}
