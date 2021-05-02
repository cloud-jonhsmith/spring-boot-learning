package com.domain.projectname.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example") //localhost:8080/example
public class ExampleController {
	
	//Primera forma
	@RequestMapping(value="/exampleString", method = RequestMethod.GET)
	//localhost:8080/example/exampleString
	public String exampleString() {
		return "example"; // retorna el nombre de la vista ubicada en templates
	}
	
	//Segunda forma
	@RequestMapping(value="/exampleMAV", method = RequestMethod.GET)
	//localhost:8080/example/exampleMAV
	public ModelAndView exampleMAV() {
		return new ModelAndView("example");
	}

}
