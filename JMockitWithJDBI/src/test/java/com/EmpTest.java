package com;
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runner.RunWith;
import mockit.*;
import java.util.*;
import mockit.integration.junit4.JMockit;
@RunWith(JMockit.class)
public class EmpTest {
	@Test
	public void testProperty() {
	final Emp emp = new Emp();
	emp.setId(100);
	emp.setName("Raj");
	emp.setSalary(12000);
	assertEquals(100,emp.getId());
	assertEquals("Raj",emp.getName());
	assertEquals(12000,emp.getSalary());
	}		
	@Test 
	public void testAddEmpDetails(@Mocked final EmpDao empDao) {
		new Expectations(){
			
			{
			empDao.addEmpDao(1001,"Raj",12000); result = 1;
			empDao.addEmpDao(1002,"Raju",14000); result = -1;
			}
	
		};
			
		new MockUp<Emp>() {
			
			@Mock
			EmpDao dao() {
			return empDao;
			}
		
		};
		
		String res1 = Emp.addEmpDetails(1001,"Raj",12000);
		assertEquals("Successfully Inserted",res1);
		System.out.println(res1);	
		String res2 = Emp.addEmpDetails(1002,"Raju",14000);
		assertEquals("Failure try once again",res2);
		System.out.println(res2);	
	   }

	  @Test 
	public void testupdateEmp(@Mocked final EmpDao empDao) {
		new Expectations(){
			
			{
			Emp emp1 =new Emp(1,"Raj",25000);
			empDao.displayOneEmp(1); result = emp1;
			empDao.decrementEmpSalary(1,2500);result = 1;

			Emp emp2 =new Emp(2,"Raju",10000);
			empDao.displayOneEmp(2); result = emp2;
			empDao.incrementEmpSalary(2,5000);result = -1;			
			}
	
		};
			
		new MockUp<Emp>() {
			
			@Mock
			EmpDao dao() {
			return empDao;
			}
		
		};
		
		String res1 = Emp.updateEmp(1);
		assertEquals("Successfully Updated",res1);
		System.out.println(res1);	
		
		String res2 = Emp.updateEmp(2);
		assertEquals("There is no record with the id as "+2,res2);
		System.out.println(res2);
	   }			   
}
