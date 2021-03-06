package com.domain.projectname.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.domain.projectname.controller.Example3Controller;

//Esto crea un bean que Spring lo guarda en su memoria
@Component("exampleComponent")
public class ExampleComponent {
	
	private static final Log LOG = LogFactory.getLog(ExampleComponent.class);
	
	public void sayHello() {
		LOG.info("HELLO FROM EXAMPLECOMPONENT");
	}

}
