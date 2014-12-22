package com.qiheng.hibernate;

import java.util.Set;

public class Course {
	
	private String id;
	
	private String course_name;
	
	private int credit;
	
	private Set<Student> students;

	
	
	public Course() {
		super();
	}

	public Course(String course_name, int credit) {
		super();
		this.course_name = course_name;
		this.credit = credit;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	
	
	
}
