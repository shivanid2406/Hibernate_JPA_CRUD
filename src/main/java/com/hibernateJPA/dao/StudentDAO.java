package com.hibernateJPA.dao;

import java.util.List;

import com.hibernateJPA.entity.Student;

public interface StudentDAO {

	void save(Student theStudent);
	Student findbyId(Integer id);
	List<Student> findAll();
	List<Student> findByLastName(String lastName);
	void update(Student theStudent);
	void delete(Integer id);
	int deleteAll();
}
