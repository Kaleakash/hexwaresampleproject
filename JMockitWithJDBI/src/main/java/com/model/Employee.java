package com.model;
import org.skife.jdbi.v2.DBI;
import java.util.*;
public class Employee {
	private int id;
	private String name;
	private float salary;
	public Employee(){
	
	}
	public Employee(int id, String name, float salary){
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public float getSalary() {
		return salary;
	}

	@Override
	public boolean equals(Object obj){
		if(obj==null){
			return false;
		}
		if(getClass()!=obj.getClass()){
			return false;
		}
		Employee emp = (Employee)obj;
		if(Objects.equals(this.id,emp.id) && Objects.equals(this.name,this.name) && Objects.equals(this.salary,emp.salary)){
			return true;
		}else {
			return false;
		}
	}
	@Override 
	public int hashCode() {
		return Objects.hash(id,name,salary);
	}
	@Override
	public String toString() {
	return "Id is "+id+" Name is "+name+" Salary is "+salary; 
	}	
	
	
	
		
}