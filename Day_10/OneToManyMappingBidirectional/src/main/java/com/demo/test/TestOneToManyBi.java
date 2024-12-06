package com.demo.test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Department;
import com.demo.beans.Employee;

public class TestOneToManyBi {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Department d1=new Department();
		d1.setDeptid(10);
		d1.setDname("admin");
		d1.setDloc("pune");
		Department d2=new Department();
		d2.setDeptid(20);
		d2.setDname("HR");
		d2.setDloc("pune");
		Employee e1=new Employee(100,"xxxx",3456,LocalDate.of(2024,11,15),d1);
		Employee e2=new Employee(200,"yyyy",5555,LocalDate.of(2023,11,15),d1);
		Employee e3=new Employee(101,"ppppp",5656,LocalDate.of(2021,11,15),d2);
		Employee e4=new Employee(201,"ssss",7676,LocalDate.of(2020,11,15),d2);
		Set<Employee> s1=new HashSet<>();
		s1.add(e1);
		s1.add(e2);
		d1.setElist(s1);
		Set<Employee> s2=new HashSet<>();
		s2.add(e3);
		s2.add(e4);
		d2.setElist(s2);
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		sess.save(d1);
		sess.save(d2);
		sess.save(e1);
		sess.save(e2);
		sess.save(e3);
		sess.save(e4);
		tr.commit();
		

	}

}
