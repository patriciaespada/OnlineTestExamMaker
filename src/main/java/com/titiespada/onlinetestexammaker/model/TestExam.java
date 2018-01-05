package com.titiespada.onlinetestexammaker.model;

// default package
// Generated 4/jan/2018 17:26:31 by Hibernate Tools 5.2.6.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TestExam generated by hbm2java
 */
@Entity
@Table(name = "test_exam")
public class TestExam implements java.io.Serializable {

	private int id;
	private String name;
	private String description;
	private int passScore;
	private int totalScore;
	private int examDuration;
	private Set questions = new HashSet(0);
	private Set testExamUsers = new HashSet(0);

	public TestExam() {
	}

	public TestExam(int id, String name, String description, int passScore, int totalScore, int examDuration) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.passScore = passScore;
		this.totalScore = totalScore;
		this.examDuration = examDuration;
	}

	public TestExam(int id, String name, String description, int passScore, int totalScore, int examDuration,
			Set questions, Set testExamUsers) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.passScore = passScore;
		this.totalScore = totalScore;
		this.examDuration = examDuration;
		this.questions = questions;
		this.testExamUsers = testExamUsers;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", nullable = false, length = 1000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "pass_score", nullable = false)
	public int getPassScore() {
		return this.passScore;
	}

	public void setPassScore(int passScore) {
		this.passScore = passScore;
	}

	@Column(name = "total_score", nullable = false)
	public int getTotalScore() {
		return this.totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	@Column(name = "exam_duration", nullable = false)
	public int getExamDuration() {
		return this.examDuration;
	}

	public void setExamDuration(int examDuration) {
		this.examDuration = examDuration;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "question_test_exam", joinColumns = {
			@JoinColumn(name = "test_exam_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "question_id", nullable = false, updatable = false) })
	public Set getQuestions() {
		return this.questions;
	}

	public void setQuestions(Set questions) {
		this.questions = questions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "testExam")
	public Set getTestExamUsers() {
		return this.testExamUsers;
	}

	public void setTestExamUsers(Set testExamUsers) {
		this.testExamUsers = testExamUsers;
	}

}