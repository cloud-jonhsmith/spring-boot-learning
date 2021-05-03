package com.domain.projectname.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Example4Controller {
	
	@GetMapping("404")
	public String get404() {
		return "404";
	}

}
