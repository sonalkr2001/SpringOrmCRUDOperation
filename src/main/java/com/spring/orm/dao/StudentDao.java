package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {
	private HibernateTemplate hibernateTemplate;
	
	// for save/insert student detail into table.
	@Transactional
	public int insert(Student student)
	{
	  Integer i	=(Integer)this.hibernateTemplate.save(student);
		return i;
	}
	
	//get/select the single data(object) from databse.
	public Student getStudent(int studentId)
	{
		Student st=this.hibernateTemplate.get(Student.class, studentId);
		return st;
	}
	
	// get/select all data(object) from databse.
	public List<Student> getallStudent()
	{
		List<Student> allstudents=this.hibernateTemplate.loadAll(Student.class);
		return allstudents;
	}
	// Delete a record from databse.
	@Transactional
	public void deleteStudent(int studentId)
	{
		Student st1=this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(st1);
	}
	
	//  update record in databse.
	@Transactional
	public void updateStudent(Student student)
	{
		this.hibernateTemplate.update(student);
	}

	public StudentDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDao(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	public HibernateTemplate getHibernateTemplate()
	{
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate)
	{
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
