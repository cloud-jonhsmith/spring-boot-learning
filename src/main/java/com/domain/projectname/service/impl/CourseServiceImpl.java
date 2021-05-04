package com.domain.projectname.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.domain.projectname.entity.Course;
import com.domain.projectname.repository.CourseJpaRepository;
import com.domain.projectname.service.CourseService;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;

	@Override
	public List<Course> listAllCourses() {
		return courseJpaRepository.findAll();
	}

	@Override
	public Course addCourse(Course course) {
		return courseJpaRepository.save(course);
	}

	@Override
	public int removeCourse(int id) {
		courseJpaRepository.deleteById(id);
		return 0;
	}

	@Override
	public Course updateCourse(Course course) {
		return courseJpaRepository.save(course);
	}

}
