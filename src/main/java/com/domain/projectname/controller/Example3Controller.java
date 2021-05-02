package com.domain.projectname.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.domain.projectname.model.Person;

@Controller
@RequestMapping("example3")
public class Example3Controller {
	
	public static final String FORM_VIEW = "form";
	public static final String RESULT_VIEW = "result";
	
	@GetMapping("showform")
	public String showForm(Model model) {
		model.addAttribute("person", new Person());
		return FORM_VIEW;
		
	}
	
	//Luego de hacer click en el botón del formulario nos envía a esta url
	//localhost:8080/example3/addperson
	@PostMapping("addperson")
	//Para capturar los datos enviados desde el formulario "form.html", ese formulario nos envía
	//un objecto llamado "person" con atributos rellenos "name" y "age", y ese objeto se captura
	//con "@ModelAttribute", se agrega el tipo y el nombre (puede ser cualquier nombre)
	public ModelAndView addPerson(@ModelAttribute("person") Person personaaa) {
		ModelAndView mav = new ModelAndView(RESULT_VIEW);
		mav.addObject("person", personaaa);
		return mav;
	}

}
