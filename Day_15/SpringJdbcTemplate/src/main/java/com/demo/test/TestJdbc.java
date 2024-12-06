package com.demo.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Product;
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
			System.out.println("accept id to delete");
			int pid=sc.nextInt();
			boolean status=pservice.removeById(pid);
			if(status) {
				System.out.println("Product deleted successfully");
			}else {
				System.out.println("product not found");
			}
	
			break;
		case 3:
			System.out.println("accept id to update");
			pid=sc.nextInt();
			System.out.println("accept new qty");
			int qty=sc.nextInt();
			System.out.println("accept new price");
			double price=sc.nextDouble();
			
			status=pservice.updateById(pid,qty,price);
			if(status) {
				System.out.println("Product updated successfully");
			}else {
				System.out.println("product not found");
			}
			break;
		case 4:
			System.out.println("accept id to search");
			 pid=sc.nextInt();
			Product p=pservice.getById(pid);
			if(p!=null) {
				System.out.println(p);
			}else {
				System.out.println("product not found");
			}
	
			break;
		case 5:
			List<Product> plist= pservice.getAllProducts();
			plist.forEach(System.out::println);
			
			break;
		case 6:System.out.println("accept price");
		 price=sc.nextDouble();
		plist=pservice.getByPrice(price);
		if(plist!=null) {
			plist.forEach(System.out::println);
		}else {
			System.out.println("product not found");
		}

			
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
