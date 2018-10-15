package com;
import javax.xml.bind.annotation.*;
@XmlRootElement
public class Emp {
	private int id;
	private String name;
	private float salary;
	public void setId(int id) {
		this.id = id;	}
	public void setName(String name) {
		this.name = name;	}
	public void setSalary(float salary) {
		this.salary = salary;	}
	public int getId() {
		return id;	}
	public String getName() {
		return name;	}
	public float getSalary() {
		return salary;	}
}