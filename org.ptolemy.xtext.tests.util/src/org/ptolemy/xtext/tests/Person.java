package org.ptolemy.xtext.tests;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Person {

	public static String NAME_PROPERTY = "name";
	public static String EMAIL_PROPERTY = "email";
	
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
		if (name == this.name || (name != null && name.equals(this.name))) {
			return;
		}
		PropertyChangeEvent changeEvent = new PropertyChangeEvent(this, NAME_PROPERTY, this.name, name);
		this.name = name;
		pcs.firePropertyChange(changeEvent);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email == this.email || (email != null && email.equals(this.email))) {
			return;
		}
		PropertyChangeEvent changeEvent = new PropertyChangeEvent(this, NAME_PROPERTY, this.email, email);
		this.email = email;
		pcs.firePropertyChange(changeEvent);
	}
	
	private PropertyChangeSupport pcs = null;
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		if (pcs == null) {
			pcs = new PropertyChangeSupport(this);
		}
		pcs.addPropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		if (pcs != null) {
			pcs.removePropertyChangeListener(listener);
		}
	}
}
