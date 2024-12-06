package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Product;
import com.demo.beans.Student;

public class TestStudentMapping {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Student s=new Student(131,"Rajani","6666",98);
		Student s1=new Student(141,"Archana","5555",97);
		Product p=new Product(1001,"Table",2,4000);
		session.save(s);
		session.save(s1);
		session.save(p);
		tr.commit();
		session.close();
		sf.close();
		

	}

}
