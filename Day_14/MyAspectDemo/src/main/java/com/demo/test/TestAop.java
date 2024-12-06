package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.MyClass;

public class TestAop {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
		MyClass ob=(MyClass)ctx.getBean("myClass");
		ob.m3(12);
		ob.getX();
	}

}
