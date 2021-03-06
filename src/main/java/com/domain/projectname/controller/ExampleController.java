package com.domain.projectname.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.domain.projectname.component.ExampleComponent;
import com.domain.projectname.model.Person;
import com.domain.projectname.service.ExampleService;

@Controller
@RequestMapping("example") //localhost:8080/example
public class ExampleController {
	
	public static final String EXAMPLE_VIEW = "example";
	
	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService; //Se debe llamar a la interface, no a la clase
	
	//Inyectando un componente (ExampleComponent)
	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;
	
	//Primera forma
	@GetMapping("exampleString")
	//localhost:8080/example/exampleString
	public String exampleString(Model model) {
		exampleComponent.sayHello();
		model.addAttribute("people", exampleService.getListPeople());
		return EXAMPLE_VIEW; // retorna el nombre de la vista ubicada en templates
	}
	
	//Segunda forma
	@GetMapping("exampleMAV")
	//localhost:8080/example/exampleMAV
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("people", exampleService.getListPeople());
		return mav;
	}
	
	/*private List<Person> getPeople(){
		List<Person> people = new ArrayList<>();
		people.add(new Person("Juan", 30));
		people.add(new Person("Jose", 29));
		people.add(new Person("Flor", 24));
		people.add(new Person("Lucero", 28));
		people.add(new Person("Yessi", 27));
		people.add(new Person("Jonh", 32));
		return people;
	}*/

}
