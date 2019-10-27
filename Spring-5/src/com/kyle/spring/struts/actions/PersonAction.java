package com.kyle.spring.struts.actions;

import com.kyle.spring.struts.services.PersonService;

public class PersonAction {

	private PersonService personService;
	
	public void setPersonService(PersonService personService){
		this.personService = personService;
	}
	
	public String execute(){
		System.out.println("execute...");
		personService.save();
		return "success";
	}
}
