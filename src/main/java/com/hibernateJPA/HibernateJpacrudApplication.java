package com.hibernateJPA;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hibernateJPA.dao.StudentDAO;
import com.hibernateJPA.entity.Student;

@SpringBootApplication
public class HibernateJpacrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateJpacrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			readStudent(studentDAO);
			findAllStudents(studentDAO);
			findByLastName(studentDAO);
			updateStudent(studentDAO);
			deleteStudent(studentDAO);
			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		int studDeleted = studentDAO.deleteAll();
		System.out.println(studDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		int id = 1;
		studentDAO.delete(id);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub

		int studId = 2;
		Student mystud = studentDAO.findbyId(studId);
		mystud.setLastName("Borgave");
		studentDAO.update(mystud);
		System.out.println(mystud);
	}

	private void findByLastName(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		List<Student> stud = studentDAO.findByLastName("Deshmukh");
		for (Student temp : stud) {
			System.out.println(temp);
		}

	}

	private void findAllStudents(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		List<Student> stud = studentDAO.findAll();
		for(Student temp:stud) {
			System.out.println(temp);
		}

	}

	private void readStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		System.out.println("Creating new student object..");
		Student tempStudent5 = new Student("James", "Gosling", "james1@gmail.com");

		System.out.println("Saving student object..");
		studentDAO.save(tempStudent5);

		System.out.println("Saved student. Generated is is: " + tempStudent5.getId());

		Student mystud = studentDAO.findbyId(tempStudent5.getId());
		System.out.println("the student is: " + mystud);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// TODO Auto-generated method stub

		System.out.println("Creating 2 new students..");
		Student tempStudent1 = new Student("Joey", "Tribianni", "joe1@gmail.com");
		Student tempStudent2 = new Student("Michael", "Scott", "mike@gmail.com");

		System.out.println("Saving 2 objects..");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);

	}

	private void createStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub

		System.out.println("Creating new student object..");
		Student tempStudent = new Student("Shivani", "Deshmukh", "shiv24@gmail.com");
		studentDAO.save(tempStudent);
	}
}
