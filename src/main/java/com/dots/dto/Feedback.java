package com.dots.dto;

import java.io.Serializable;

public class Feedback implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String feedback;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	
}
