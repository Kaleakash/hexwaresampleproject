package com;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
     @Before 
     public void setResource() {
	System.out.println("Before testing");	
     }     

   @After 
     public void removeResource() {
	System.out.println("After testing");	
     }

    @Test
   public void addTest() {
System.out.println("While testing");
	Cal cc = new Cal();
	int res = cc.add(10,20);
	assertEquals(30,res);
    }
}





