package com.manoj.SpringJDBC;

import com.manoj.SpringJDBC.model.Student;
import com.manoj.SpringJDBC.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);
		Student student = context.getBean(Student.class);
		student.setId(29);
		student.setName("Manoj");
		student.setMarks(90);

		StudentService service = context.getBean(StudentService.class);

		service.addStudent(student);

		List<Student> studentList = service.findAllStudents();

		System.out.println(studentList);

	}

}
