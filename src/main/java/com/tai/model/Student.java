package com.tai.model;

public class Student {
	
	public Student() {
		
	}

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
}
