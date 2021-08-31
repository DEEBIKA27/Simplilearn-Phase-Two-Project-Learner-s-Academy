package com.simplilearn.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.simplilearn.entity.Student;
import com.simplilearn.entity.Teacher;

public class HibernateUtil {

	static SessionFactory sessionFactory = null;

	public static SessionFactory buildSessionFactory() {
				SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")		
				.addAnnotatedClass(Student.class)	
				.buildSessionFactory();
		return sessionFactory;
	}


}