package com;
import java.util.*;
public class Employee {
	private String name="Raj";
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("Name setted...");
		this.name = name;
	}
	public List getList() {
	List ll = new ArrayList();
	ll.add("A");	ll.add("B");	ll.add("C");	ll.add("D");
	// Retrieving records form database using JDBI
	return ll;
	}
}

 
