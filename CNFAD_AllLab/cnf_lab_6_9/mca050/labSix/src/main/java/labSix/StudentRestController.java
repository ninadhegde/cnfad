package labSix;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentRestController {
@GetMapping
public List<Student> getdata() {
Configuration cfg=new Configuration().configure(); 
SessionFactory sFactory =cfg.buildSessionFactory();
Session ss=sFactory.openSession();
	List<Student> output=ss.createQuery("FROM Student").list();
	return output;
}
}
