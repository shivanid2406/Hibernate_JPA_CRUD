package com.hibernateJPA.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hibernateJPA.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private EntityManager entityManager;

	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Student theStudent) {

		entityManager.persist(theStudent);
	}

	@Override
	public Student findbyId(Integer id) {

		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {

		TypedQuery<Student> theQuery = entityManager.createQuery("from Student", Student.class);
		return theQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName(String lastName) {

		TypedQuery<Student> lastNameQuery = entityManager.createQuery("from Student where lastName=:theData",
				Student.class);
		return lastNameQuery.getResultList();
	}

	@Override
	@Transactional
	public void update(Student theStudent) {

		entityManager.merge(theStudent);
	}

	@Override
	@Transactional
	public void delete(Integer id) {

		Student theStudent = entityManager.find(Student.class, id);
		entityManager.remove(theStudent);
	}

	@Override
	@Transactional
	public int deleteAll() {

		int rowsDeleted = entityManager.createQuery("delete from Student").executeUpdate();
		return rowsDeleted;
	}

}
