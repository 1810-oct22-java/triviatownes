package com.ex.beans.game;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity //registers class as entity in DB
@Table(name="GLOBALSTATS")//allows further configuration of Table in DB
public class HighScoreBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id //necessary for Hibernate to identify objects
	@Column(name="QTID")
	//@SequenceGenerator(name="U_SEQ_GEN", sequenceName="U_SEQ")
	//@GeneratedValue(generator="U_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(nullable=false, unique=true)
	private String username;
	
	@Column(nullable=false)
	private int score;
	
	@Column(nullable=false, name="MAX_STREAK")
	private int maxStreak;
	
	@Column(nullable=false, name="NUMBER_CORRECT")
	private int rightAnswers;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "HighScoreBean [id=" + id + ", username=" + username + ", score=" + score + "]";
	}
	public HighScoreBean(int id, String username, int score) {
		super();
		this.id = id;
		this.username = username;
		this.score = score;
	}
	public HighScoreBean() {
		
	}
	public int getMaxStreak() {
		return maxStreak;
	}
	public void setMaxStreak(int maxStreak) {
		this.maxStreak = maxStreak;
	}
	public int getRightAnswers() {
		return rightAnswers;
	}
	public void setRightAnswers(int rightAnswers) {
		this.rightAnswers = rightAnswers;
	}
	
	
	
	
	
}
