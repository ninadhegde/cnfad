package com.example.labSeven;

import java.util.*;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LabSevenApplication {
	
	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(LabSevenApplication.class, args);
		int ch,id;
		int marks;
		String name;
		StudentService ss=context.getBean(StudentService.class);
		Scanner scanner=new Scanner(System.in);
		while(true) {
			System.out.println("1.Create\n2.Retrieve\n3.Update\n4.Delete\n5.Exit\nEnter choice:");
			ch=scanner.nextInt(); 
			switch (ch) {
			case 1: {
			System.out.println("Enter name and marks");			
			name=scanner.next();
			marks=scanner.nextInt();
			ss.insert(name,marks);
			break;
			}		
			case 2: {
				List<Student> s=ss.display();
				for(Student i:s) {
					System.out.println(i.toString());
				}					
				break;
				}		
			case 3: {
				System.out.println("Enter id and new marks:");
				id=scanner.nextInt();
				marks=scanner.nextInt();
				ss.update(id, marks);
				break;
				}		
			case 4: {
				System.out.println("Enter id:");
			id=scanner.nextInt();
			ss.delete(id);
				
				break;
				}		
			case 5: {
			System.exit(0);
				}		
			}
		}
	}

}
