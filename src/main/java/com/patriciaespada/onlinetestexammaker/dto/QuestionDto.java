package com.patriciaespada.onlinetestexammaker.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.patriciaespada.onlinetestexammaker.model.Question;

public class QuestionDto implements Serializable {
	
	private static final long serialVersionUID = 336695255005495635L;
	
	private int id;
	private String title;
	private String problemDescription;
	private boolean haveMoreThanOneAnswer;
	private int order;
	private List<QuestionChoiceAnswerDto> questionChoiceAnswerDtoList = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getProblemDescription() {
		return problemDescription;
	}
	
	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}
	
	public boolean isHaveMoreThanOneAnswer() {
		return haveMoreThanOneAnswer;
	}
	
	public void setHaveMoreThanOneAnswer(boolean haveMoreThanOneAnswer) {
		this.haveMoreThanOneAnswer = haveMoreThanOneAnswer;
	}
	
	public int getOrder() {
		return order;
	}
	
	public void setOrder(int order) {
		this.order = order;
	}
	
	public List<QuestionChoiceAnswerDto> getQuestionChoiceAnswerDtoList() {
		return questionChoiceAnswerDtoList;
	}
	
	public void setQuestionChoiceAnswerDtoList(List<QuestionChoiceAnswerDto> questionChoiceAnswerDtoList) {
		this.questionChoiceAnswerDtoList = questionChoiceAnswerDtoList;
	}

	@Override
	public String toString() {
		return "QuestionDto [id=" + id + ", title=" + title + ", problemDescription=" + problemDescription
				+ ", haveMoreThanOneAnswer=" + haveMoreThanOneAnswer + ", order=" + order
				+ ", questionChoiceAnswerDtoList=" + questionChoiceAnswerDtoList + "]";
	}
	
	public static QuestionDto createQuestionDto(Question question, int order, List<QuestionChoiceAnswerDto> questionChoiceAnswerDtoList) {
		QuestionDto questionDto = new QuestionDto();
		questionDto.setId(question.getId());
		questionDto.setTitle(question.getTitle());
		questionDto.setProblemDescription(question.getProblemDescription());
		questionDto.setHaveMoreThanOneAnswer(question.isHaveMoreThanOneAnswer());
		questionDto.setOrder(order);
		questionDto.setQuestionChoiceAnswerDtoList(questionChoiceAnswerDtoList);
		return questionDto;
	}
	
	

}
