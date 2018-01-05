package com.titiespada.onlinetestexammaker.dto;

import java.io.Serializable;

import com.titiespada.onlinetestexammaker.model.QuestionChoiceAnswer;

public class QuestionChoiceAnswerDto implements Serializable {

	private static final long serialVersionUID = 7154655185419626844L;
	
	private int id;
	private String text;
	private String displayOrder;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getDisplayOrder() {
		return displayOrder;
	}
	
	public void setDisplayOrder(String displayOrder) {
		this.displayOrder = displayOrder;
	}

	@Override
	public String toString() {
		return "QuestionChoiceAnswerDto [id=" + id + ", text=" + text + ", displayOrder=" + displayOrder + "]";
	}
	
	public static QuestionChoiceAnswerDto createQuestionChoiceAnswerDto(QuestionChoiceAnswer questionChoiceAnswer) {
		QuestionChoiceAnswerDto questionChoiceAnswerDto = new QuestionChoiceAnswerDto();
		questionChoiceAnswerDto.setId(questionChoiceAnswer.getId());
		questionChoiceAnswerDto.setText(questionChoiceAnswer.getText());
		questionChoiceAnswerDto.setDisplayOrder(questionChoiceAnswer.getDisplayOrder());
		return questionChoiceAnswerDto;
	}
	
}
