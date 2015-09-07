package com.pqt.forcadevendas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/test")
	public String test(){
		System.out.println("Hello!!!!!!!!");
		return "Hello!";
	}

}
