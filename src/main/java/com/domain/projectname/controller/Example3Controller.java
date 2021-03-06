package com.domain.projectname.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.domain.projectname.model.Person;

@Controller
@RequestMapping("example3")
public class Example3Controller {
	
	private static final Log LOGGER = LogFactory.getLog(Example3Controller.class);
	
	public static final String FORM_VIEW = "form";
	public static final String RESULT_VIEW = "result";
	
	//******************REDIRECCIONAMIENTO***************************
	//Redireccionando PRIMERA FORMA
	@GetMapping("/")
	public String redirect() {
		return "redirect:/example3/showform";
	}
	@GetMapping("")
	public String redirectVacio() {
		return "redirect:/example3/showform";
	}
	
	//Redireccionando SEGUNDA FORMA (Usando RedirectView)
	/*@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/example3/showform");
	}
	@GetMapping("")
	public RedirectView redirectVacio() {
		return new RedirectView("/example3/showform");
	}*/
	//******************FIN REDIRECCIONAMIENTO**********************
	
	//Agregando y visualizando los LOGS
	@GetMapping("showform")
	public String showForm(Model model) {
		/*
		LOGGER.info("INFO TRACE");
		LOGGER.warn("WARNING TRACE");
		LOGGER.error("ERROR TRACE");
		LOGGER.debug("DEBUG TRACE");*/
		model.addAttribute("person", new Person());
		return FORM_VIEW;
		
	}
	
	//Luego de hacer click en el botón del formulario nos envía a esta url
	//localhost:8080/example3/addperson
	@PostMapping("addperson")
	//Para capturar los datos enviados desde el formulario "form.html", ese formulario nos envía
	//un objecto llamado "person" con atributos rellenos "name" y "age", y ese objeto se captura
	//con "@ModelAttribute", se agrega el tipo y el nombre (puede ser cualquier nombre)
	public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {
		//al agregar "@Valid" (validación), Spring necesita agregar el "BindingResult" para
		//comprobar si es válido o no, en caso de no ser válido algún campo de este objeto,
		//lo mete en el campo fields y lo va a retornar junto con la vista
		ModelAndView mav = new ModelAndView();
		if(bindingResult.hasErrors()) {
			mav.setViewName(FORM_VIEW);
		} else {
			mav.setViewName(RESULT_VIEW);
			mav.addObject("person", person);
		}
		return mav;
	}

}
