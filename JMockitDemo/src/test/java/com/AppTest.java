package com;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runner.RunWith;
import mockit.*;
import mockit.integration.junit4.JMockit;
@RunWith(JMockit.class)
public class AppTest {
	@Test 
	public void testEmployee() {
	final Employee emp1=new Employee();
	emp1.setName("Raju");
	String name =emp1.getName();
	assertEquals("Name may be ","Raju",name);
	List ll = emp1.getList();
	assertEquals("Number of Rec ",4,ll.size());
	}
	
	@Test 
	public void testProjects(@Mocked final Employee emp) {
	Projects pp =new Projects();
		new Expectations(){	//anonymouse inner class 
			{	// anonymouse method or block 
			System.out.println("getName() mocked method called...");
			emp.getName();
			result = "Veeta";
			}
		};
		
		new Expectations(){	//anonymouse inner class 
			{	// anonymouse method or block 
			emp.getList();
			List ll = new ArrayList();
			ll.add("Akash");	ll.add("Vikash");
			//result = null;
			result = ll;
			}
		};
	Employee e = pp.getEmployeeInstance();	
	String name = e.getName();
	assertEquals("Name should be Seeta","Veeta",name);
	List ll = pp.getListOfData();
	assertEquals("Number of employee are ",2,ll.size());
	//assertNull(ll);
	}			
}