package com.domain.projectname.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.domain.projectname.entity.Course;
import com.domain.projectname.entity.QCourse;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {
	
	private QCourse qCourse = QCourse.course;
	
	@PersistenceContext //debemos indicar una anotación que nos dice que este objeto (em)
						//se encuentra en el contexto de la persistencia de la aplicación
	private EntityManager em; //para obtener el entity manager (em)
	
	public Course find(boolean exist) {
		
		//el em (entity manager) es un objeto que se encarga de gestionar las entidades
		//de la persistencia de la aplicación
		JPAQuery<Course> query = new JPAQuery<Course>(em);
		
		BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("OP"));
		
		//Predicate predicate1 = qCourse.description.endsWith("OP");
		
		if(exist) {
			Predicate predicate2 = qCourse.id.eq(23);
			predicateBuilder.and(predicate2);
		} else {
			Predicate predicate3 = qCourse.name.endsWith("OP");
			predicateBuilder.or(predicate3);
		}
		
		//Course course1 = query.select(qCourse).from(qCourse).where(qCourse.id.eq(23)).fetchOne();
		//Course course1 = query.select(qCourse).from(qCourse).where(predicateBuilder).fetchOne();
		return query.select(qCourse).from(qCourse).where(predicateBuilder).fetchOne();
		
		
		//Si solo queremos traer solo el nombre y la descripción, escribiremos lo siguiente:
		//Course course1 = (Course) query.select(qCourse.name, qCourse.description).from(qCourse).where(qCourse.id.eq(23)).fetchOne();
		
		//List<Course> courses = query.select(qCourse).from(qCourse).where(qCourse.hours.between(20, 50)).fetch();
		
	}

}
