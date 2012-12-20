package org.ptolemy.xtext.tests;

public class Person {

	private String name, email;

	public Person() {
		super();
	}

	public Person(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
