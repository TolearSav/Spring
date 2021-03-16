package com.helloworld2.hello2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello2")
public class Hello2Controller {
	
	@GetMapping
	public String hello2() {
		return "Aprender Spring e aprimorar os conhecimentos em MySQL.";
	}

}
