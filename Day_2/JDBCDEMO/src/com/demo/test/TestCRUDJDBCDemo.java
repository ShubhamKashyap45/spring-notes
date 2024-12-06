package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.MyUSer;
import com.demo.beans.Product;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

public class TestCRUDJDBCDemo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter user name: ");
		String uname=sc.next();
		System.out.println("Enter password");
		String passwd=sc.next();            
		LoginService ls=new LoginServiceImpl();
		MyUSer user=ls.validateUser(uname,passwd);
		ProductService ps=new ProductServiceImpl();
		int choice=0;
		if(user!=null && user.getRole().equals("admin")) {
			System.out.println("1. Add new product\n2. Delete Product\n3. update product\n4.Display all");
			System.out.println("5. Find By ID\n6. display in sorted order by name\n7.exit\n choice:");
			switch(choice) {
				case 1->{
					boolean status=ps.addProduct();
					if(status) {
						System.out.println("insertion done");
					}else {
						System.out.println("error occured");
					}
					
				}
	
				case 2->{
					System.out.println("Enter pid: ");
					int pid = sc.nextInt();
					boolean status = ps.removeById(pid);
					if(status) {
						System.out.println("Deleted successfully");
					}
					else {
						System.out.println("Not found");
					}
				}
				case 3->{
					System.out.println("Enter pid: ");
					int pid = sc.nextInt();
					System.out.println("Enter new quantity: ");
					int qty = sc.nextInt();
					System.out.println("Enter new price: ");
					double price =sc.nextDouble();
					boolean status = ps.updateById(pid, qty, price);
					if(status) {
						System.out.println("Updated successfully");
					}
					else {
						System.out.println("Not found");
					}
					
				}
				case 4->{
					List<Product>plist = ps.getAllProducts();
					if(plist!=null) {
						plist.stream().forEach(System.out::println);
					}else {
						System.out.println("not found");
					}
				}
				case 5->{
					System.out.println("Enter id: ");
					int pid = sc.nextInt();
					Product p = ps.getById(pid);
					if(p!=null) {
						System.out.println(p);
					}
					else {
						System.out.println("not found");
					}
				}
				case 6-> {
					List<Product>plist = ps.getSortedByName();
					if(plist!=null) {
						plist.stream().forEach(System.out::println);
					}else {
						System.out.println("not found");
					}
				}
				case 7->{
					System.out.println("Thank you for visiting....");
					sc.close();
					ps.closeMyConnection();
				}
				default->{
					System.out.println("invalid choice");
				}
			}
		}else {
			if(user!=null && user.getRole().equals("user")) {
				System.out.println("1. Display all Product sorted by price \n2. Display By Id \n3. Display by name\n");
			}
		}

	}

}
