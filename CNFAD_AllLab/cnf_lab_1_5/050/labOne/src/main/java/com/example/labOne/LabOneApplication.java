package com.example.labOne;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
public class LabOneApplication {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		SpringApplication.run(LabOneApplication.class, args);
		ApplicationContext ac = new ClassPathXmlApplicationContext("xmlConf.xml");
		Customer dt =(Customer) ac.getBean("customer");
		Ticket ticket=dt.getTicket();		
		while(true) {
			System.out.println("1. insert the Customer details\n "
			+ "2. Display details \n"
			+ "3. exit");{

			}
			System.out.println("enter the choice");
			int a = sc.nextInt();
			switch(a) {
				case 1:
					System.out.println("enter the  name");
					dt.setName(sc.next());
					System.out.println("enter the ticket id");
					ticket.setId(sc.nextInt());
					System.out.println("enter the ticket price");
					ticket.setPrice(sc.nextInt());
					System.out.println("thanks for input");
					break;
				case 2:
					System.out.println("Name:"+dt.getName()+" "+"ID:"+ticket.getId()+
					" Price"+ticket.getPrice());
					break;
				case 3:
					System.exit(0);
			}
		}

	}
}
