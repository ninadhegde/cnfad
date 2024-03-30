package labSix;

import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class Main {
public static void main(String s[]) {
	SpringApplication.run(Main.class, s);

	Scanner scanner=new Scanner(System.in); 
Student stu=new Student(); 
Configuration cfg=new Configuration().configure(); 
SessionFactory sFactory =cfg.buildSessionFactory();
int ch;
Session ss=sFactory.openSession();

while(true) {
	Transaction transaction=ss.beginTransaction();

System.out.println("MENU\n1.Input\n2.Display All\n3.Exit\n4.Delete a record\n5.View a record\n6.Update a record\nEnter choice:");	
ch=scanner.nextInt();
switch (ch) {
case 1:
	System.out.println("Enter name and marks");
	stu.setName(scanner.next());
	stu.setTotalmarks(scanner.nextInt());
	ss.save(stu);
	transaction.commit();
	break;
case 2:
	List<Student> output=ss.createQuery("FROM Student").list();
	for(Student students:output) {
		System.out.println(students.getId()+"--"+students.getName()+"--"+students.getTotalmarks());
	}
	transaction.commit();
	break;
case 3:
ss.close();
System.exit(0);
case 4:
	System.out.println("Enter id to delete ");
	ch=scanner.nextInt();
	Student student=ss.get(Student.class, ch);
	if(student==null) {
		System.out.println("Not found ");
	}
	else {
		ss.delete(student);
		transaction.commit();
	}
	break;
case 5:
	System.out.println("Enter id to view specifically ");
	ch=scanner.nextInt();
	student=ss.get(Student.class, ch);
	if(student==null) {
		System.out.println("Student not fund!");
	}
	else {
		System.out.println(student.getName()+"--"+student.getTotalmarks());
	}
	transaction.commit();
	break;
case 6:

	System.out.println("Enter id to update ");

	ch=scanner.nextInt();

	student=ss.get(Student.class, ch);

	if(student==null) {

		System.out.println("Student not found! ");

	}

	else {

		System.out.println("Enter new marks ");

		int marks=scanner.nextInt();

		student.setTotalmarks(marks);

		ss.update(student);

		transaction.commit();

	

	}


	break;
}
}

}
	
public static void update(Session s) {

}
	
}
