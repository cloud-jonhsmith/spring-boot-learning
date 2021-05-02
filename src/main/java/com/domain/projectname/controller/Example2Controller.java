package com.domain.projectname.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("example2")
public class Example2Controller {
	
	private static final String EXAMPLE2_VIEW = "example2";
	
	//localhost:8080/example2/request1?nm=JON
	//localhost:8080/example2/request1?nm=MIKEL
	//"name" obtiene el valor que enviamos en la url en el parámetro "nm" y lo carga a la
	//variable "nm_in_model" que la usaremos en la plantilla "example2.html"
	@GetMapping("request1")
	//Se agrega required=false para que funcione si se escribe la url sin parámetros
	//localhost:8080/example2/request1
	public ModelAndView request1(@RequestParam(name="nm", required = false, defaultValue = "World") String name) {
		ModelAndView mav = new ModelAndView(EXAMPLE2_VIEW);
		mav.addObject("nm_in_model", name);
		return mav;
	}

}
