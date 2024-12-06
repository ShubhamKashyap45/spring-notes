package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Department;
import com.demo.beans.Employee;

public class TestRetrieveData {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Department d=sess.get(Department.class, 10);
		System.out.println(d.getDname());
		System.out.println("After Dname");
		System.out.println(d.getElist());
		Employee e=sess.get(Employee.class, 101);
		System.out.println(e);
		System.out.println(e.getD());
		tr.commit();
		sess.close();
		sf.close();
		
		
	}

}
