package com;
import org.skife.jdbi.v2.DBI;
import java.util.*;
public class Emp {
	private int id;
	private String name;
	private float salary;
	Emp(){
	
	}
	Emp(int id, String name, float salary){
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
	public String toString() {
	return "Id is "+id+" Name is "+name+" Salary is "+salary; 
	}	
	
	//Database Connection 
	private static EmpDao dao() {
    	DbConnection db = new DbConnection();
    	return db.getConnect().onDemand(EmpDao.class);
  	}
	

	//Add Emp Records 
	public static String addEmpDetails(int id,String name,float salary){
		int res = dao().addEmpDao(id,name,salary);
		if(res>0) {
			return "Successfully Inserted";
		}else {
			return "Failure try once again";
		}
	}

	//Delete Emp Records 
	public static String deleteEmp(int id){
		int res = dao().deleteEmpDao(id); 
		if(res>0) {
			return "Successfully Deleted";
		}else {
			return "There is no record with the id as "+id;
		}
	}

	//Update Emp Records 
	public static String updateEmp(int id){
		Emp emp = dao().displayOneEmp(id);
		float salary = emp.getSalary();
		int res = 0;
		if(salary>=25000) {
			res = dao().decrementEmpSalary(id,2500);
		}else {
			res = dao().incrementEmpSalary(id,5000);	
		}
		if(res>0) {
			return "Successfully Updated";
		}else {
			return "There is no record with the id as "+id;
		}
	}

	//Display One Emp Record 
	public static Emp displayOneEmp(int id) {
		return dao().displayOneEmp(id);
	}

		
	//Retrieve the Records 
	public static List<Emp> listAllEmp() {
    	List<Emp> es = dao().getAllEmployees();
    	return es;
  	}
	
		
}