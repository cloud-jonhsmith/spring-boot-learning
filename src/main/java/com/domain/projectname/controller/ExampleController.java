package com.domain.projectname.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.domain.projectname.model.Person;

@Controller
@RequestMapping("example") //localhost:8080/example
public class ExampleController {
	
	public static final String EXAMPLE_VIEW = "example";
	
	//Primera forma
	@GetMapping("exampleString")
	//localhost:8080/example/exampleString
	public String exampleString(Model model) {
		model.addAttribute("person", new Person("jon", 32));
		return EXAMPLE_VIEW; // retorna el nombre de la vista ubicada en templates
	}
	
	//Segunda forma
	@GetMapping("exampleMAV")
	//localhost:8080/example/exampleMAV
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("person", new Person("Smith", 33));
		return mav;
	}

}
