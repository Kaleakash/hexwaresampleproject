package com.util;
import com.factory.AccountFactory;
import com.model.Account;
import java.util.*;	

public class CliMain
{
	static Scanner obj = new Scanner(System.in);
	static int accNum;		
	static String name;
	static float amount;
	public static void createAccount(int accNumber,String name,float amount){
		
		
	}
		
    	public static void main( String[] args )
    	{
	String con = null;
	do{
		System.out.println("1:Create Account");
		System.out.println("2:Withdraw amount");
		System.out.println("3:Deposite amount");
		System.out.println("4:Check balance");
		int op = obj.nextInt();
		switch(op) {
		case 1:	System.out.println("Create account");
			break;
		case 2:	System.out.println("Withdraw amount");
			break;
		case 3:	System.out.println("Deposite amount");
			break;
		case 4:	System.out.println("Check balance");
			break;	
		
		}
		System.out.println("Do you want to continue....");
		con = obj.next();
	}while(con.equals("y"));	
	}
}
