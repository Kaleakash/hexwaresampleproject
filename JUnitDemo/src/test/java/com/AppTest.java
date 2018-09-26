package com;

import static org.junit.Assert.assertTrue;
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
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    @Test
   public void addTest() {
	Cal cc = new Cal();
	int res = cc.add(10,20);
	assertEquals(30,res);
    }
}
