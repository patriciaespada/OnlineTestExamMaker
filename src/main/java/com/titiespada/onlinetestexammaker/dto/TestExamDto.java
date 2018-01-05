package com.titiespada.onlinetestexammaker.dto;

import java.io.Serializable;

import com.titiespada.onlinetestexammaker.model.TestExam;

public class TestExamDto implements Serializable {

	private static final long serialVersionUID = 2256328321108646099L;
	
	private int id;
	private String name;
	private String description;
	private int passScore;
	private int totalScore;
	private int examDuration;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPassScore() {
		return passScore;
	}

	public void setPassScore(int passScore) {
		this.passScore = passScore;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getExamDuration() {
		return examDuration;
	}

	public void setExamDuration(int examDuration) {
		this.examDuration = examDuration;
	}

	@Override
	public String toString() {
		return "TestExamDto [id=" + id + ", name=" + name + ", description=" + description + ", passScore=" + passScore
				+ ", totalScore=" + totalScore + ", examDuration=" + examDuration + "]";
	}

	public static TestExamDto createTestExamDto(TestExam testExam) {
		TestExamDto testExamDto = new TestExamDto();
		testExamDto.setId(testExam.getId());
		testExamDto.setName(testExam.getName());
		testExamDto.setDescription(testExam.getDescription());
		testExamDto.setPassScore(testExam.getPassScore());
		testExamDto.setTotalScore(testExam.getTotalScore());
		testExamDto.setExamDuration(testExam.getExamDuration());
		return testExamDto;
	}
	
}
