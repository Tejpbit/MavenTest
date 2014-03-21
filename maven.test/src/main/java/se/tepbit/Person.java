package se.tepbit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

	private String name;
	private String surName;
	private int age;
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	public Person() {
	}
	
	public Person(String name, String surName, int age) {
		this.age = age;
		this.name = name;
		this.surName = surName;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getSurName() {
		return surName;
	}
	
	@Override
	public String toString() {
		return name + " " + surName + " " + age;
	}
}
