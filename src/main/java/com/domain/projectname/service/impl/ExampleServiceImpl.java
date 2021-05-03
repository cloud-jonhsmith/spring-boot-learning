package com.domain.projectname.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.domain.projectname.model.Person;
import com.domain.projectname.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {
	
	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);

	@Override
	public List<Person> getListPeople() {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Juan", 30));
		people.add(new Person("Jose", 29));
		people.add(new Person("Flor", 24));
		people.add(new Person("Lucero", 28));
		people.add(new Person("Yessi", 27));
		people.add(new Person("Jonh", 32));
		LOG.info("HELLO FROM SERVICE");
		return people;
	}

}
