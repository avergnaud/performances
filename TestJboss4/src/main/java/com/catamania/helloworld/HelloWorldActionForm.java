package com.catamania.helloworld;

import org.apache.struts.action.ActionForm;

public class HelloWorldActionForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
