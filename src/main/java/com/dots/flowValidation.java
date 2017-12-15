package com.dots;

import org.springframework.binding.message.MessageContext;

import com.dots.dto.Feedback;

public class flowValidation {
	
	public String validate(Feedback fb,MessageContext messageContext) {
		
		System.out.println("the feedback is:");
		System.out.println(fb.getName());
		System.out.println(fb.getFeedback());
		
		return "success";
	}

}
