package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Course;
import com.demo.beans.Faculty;

public class TestOneToOne {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Course c=new Course("java",90);
		Faculty f=new Faculty("xxx","yyyy",c);
		//add a faculty and course object into tables
		
		/*
		 * Session sess=sf.openSession(); Transaction tr=sess.beginTransaction();
		 * sess.save(c); sess.save(f); tr.commit(); sess.close();
		 */
		//retrieve faculty and course details
		Session sess2=sf.openSession();
		Faculty f1=sess2.get(Faculty.class, 4);
		System.out.println(f1);
		Course c1=sess2.get(Course.class,5);
		System.out.println(c1);
		sf.close();

	}

}
