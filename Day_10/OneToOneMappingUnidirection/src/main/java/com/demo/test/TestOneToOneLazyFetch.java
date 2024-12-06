package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Faculty;

public class TestOneToOneLazyFetch {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Faculty f=sess.load(Faculty.class, 4);
		System.out.println(f.getName()+"-----" +f.getAddress());
		System.out.println(f.getC1());
		tr.commit();
		

	}

}
