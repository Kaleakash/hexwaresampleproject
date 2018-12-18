package com;
import java.util.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws Exception
    {
    	String con=null;
    	int id;
    	String name;
    	float salary;
    	int res;

   System.out.println("JDBI Application");
        DBConnection db = new DBConnection();
        EmployeeDao empDao = db.getConnection().onDemand(EmployeeDao.class);
       Scanner sc = new Scanner(System.in);
        do {
   System.out.println("1:Add\t 2:Delete \t 3:Update 4:Display By Id \t 5:Display All");
    	   System.out.println("Enter your choice");
    	   int choice = sc.nextInt();
    	   switch(choice) {
    	   case 1:  System.out.println("Enter the id");
    	   		id = sc.nextInt();
    	   		System.out.println("Enter the name");
    	   		name = sc.next();
    	   		System.out.println("Enter the salary");
    	   		salary = sc.nextFloat();
    	   		res = empDao.insertEmp(id,name,salary);
    	   		if(res>0) {
    	   		System.out.println("Record inserted successfully");
    	   			}
    	   			break;
    	   case 2:System.out.println("Enter the id to delete the record");
    	           id = sc.nextInt();
    	          res= empDao.deleteEmp(id);
    	          		if(res>0) {
    	          		System.out.println("Record deleted successfully!");
    	          		}else {
    	          		System.out.println("Record is not present");
    	          		}
    	          	break;
    	   case 3:System.out.println("Enter the salary");
    	   		salary = sc.nextFloat();
    	   		System.out.println("Enter the id");
           			id = sc.nextInt();
           			res= empDao.updateEmp(id, salary);
           			if(res>0) {
          			System.out.println("Record updated successfully!");
           			}else {
          			System.out.println("Record is not update");
           			}
           			break;
    	   case 4:System.out.println("Enter the employee id");
    	   			id = sc.nextInt();
    	   			Employee emp = empDao.empById(id);
    	   			if(emp==null) {
    	   		System.out.println("Record is not present");
    	   			}else {
    	  System.out.println("id is "+emp.getId()+" Name is "+emp.getName()+" Salary is "+emp.getSalary());
    	   			}
    		   break;
    	   case 5:List<Employee> listOfEmp = empDao.allEmployeeDetails();
    	   			if(listOfEmp.size()==0) {
    	   				System.out.println("No record are available");
    	   			}else {
    	   				Iterator<Employee> li = listOfEmp.iterator();
    	   				while(li.hasNext()) {
    	   					Employee employee = li.next();
    	   					System.out.println("id is "+employee.getId()+" Name is "+employee.getName()+" Salary is "+employee.getSalary());
    	   				}
    	   			}
    		   break;
    	   default:System.out.println("Wrong choice");
    		   break;
    	   }
        	System.out.println("Do you want to continue?");
        	con = sc.next();
       }while(con.equalsIgnoreCase("y"));
        System.exit(0);
    }
}
