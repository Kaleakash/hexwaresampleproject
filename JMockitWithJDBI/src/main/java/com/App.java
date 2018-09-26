package com;
import java.util.*;	
public class App 
{
	static Scanner obj = new Scanner(System.in);
	static int id;		
	static String name;
	static float salary;
	public static void addEmp(int id,String name,float salary){
		String res = Emp.addEmpDetails(id,name,salary);
		System.out.println(res);
	}
	public static void deleteEmp(int id) {
		String res = Emp.deleteEmp(id);
		System.out.println(res);	
	}		
	public static void updateEmp(int id) {
		String res = Emp.updateEmp(id);
		System.out.println(res);	
	}
	public static void displayAll() {
	System.out.println("All Employee Information");	
	List<Emp> listOfRec = Emp.listAllEmp();
	Iterator<Emp> ii = listOfRec.iterator();
		while(ii.hasNext()) {
			Emp emp = ii.next();
			System.out.println(emp);
		}
	}
	public static void displayOneEmp(int id) {
		Emp emp = Emp.displayOneEmp(id);
		if(emp ==null) {
			System.out.println("Record is not present");
		}else {
			System.out.println(emp);
		}
	}	
    	public static void main( String[] args )
    	{
	String con = null;
	do{
		System.out.println("1:Add Emp");
		System.out.println("2:Delete Emp");
		System.out.println("3:Update Emp");
		System.out.println("4:Display All Emp");
		System.out.println("5:Display Specific Emp");
		System.out.println("6:Exit");
		int op = obj.nextInt();
		switch(op) {
		case 1:	System.out.println("Enter the id");
			id = obj.nextInt();
			System.out.println("Enter the name");
			name = obj.next();
			System.out.println("Enter the salary");
			salary = obj.nextFloat();
			addEmp(id,name,salary);
			break;
		case 2:	System.out.println("Enter the id");
			id = obj.nextInt();
			deleteEmp(id);
			break;
		case 3:	System.out.println("Enter the id");
			id = obj.nextInt();
			updateEmp(id);
			break;
		case 4:	displayAll();
			break;
		case 5:	System.out.println("Enter the id");
			id = obj.nextInt();
			displayOneEmp(id);
			break;
		case 6:	System.exit(0);
			break;
		}
		System.out.println("Do you want to continue....");
		con = obj.next();
	}while(con.equals("y"));	
	}
}
