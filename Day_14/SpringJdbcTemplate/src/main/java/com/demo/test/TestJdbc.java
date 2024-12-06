package com.demo.test;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.service.ProductService;

public class TestJdbc {
  public static void main(String[] args) {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
	Scanner sc=new Scanner(System.in);
	ProductService pservice=(ProductService)ctx.getBean("productServiceImpl");
	int choice=0;
	do {
		System.out.println("1. add new product\n 2. delete product\n 3. modify product\n");
		System.out.println("4. display by id\n 5. display all\n 6. display by price\n7.exit\nchoice: ");
		choice=sc.nextInt();
		switch(choice) {
		case 1:
			pservice.addNewProduct();
			break;
		case 2:
			
			break;
		case 3:
	
			break;
		case 4:
	
			break;
		case 5:
			
			break;
		case 6:
			
			break;
		case 7:
			System.out.println("Thank you for visiting");
			sc.close();
			break;
		default:
			System.out.println("invalid choice");
			break;
		}
			
	}while(choice!=7);
}
}
