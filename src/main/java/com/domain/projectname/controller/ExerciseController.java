package com.domain.projectname.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.domain.projectname.service.MessageLogService;

@Controller
@RequestMapping("exercise")
public class ExerciseController {
	
	private static final Log LOG = LogFactory.getLog(ExerciseController.class);
	
	private static String VIEW_RETURN = "mensaje";
	
	@Autowired
	@Qualifier("messagelog")
	private MessageLogService messageLogService; 
	
	@GetMapping("method1")
	public String method1() {
		return "redirect:/exercise/method2";
	}
	
	@GetMapping("method2")
	public ModelAndView method2() {
		ModelAndView mav = new ModelAndView(VIEW_RETURN);
		String message = messageLogService.messageLog();
		mav.addObject("message_in_model", message);
		return mav;
	}

}
