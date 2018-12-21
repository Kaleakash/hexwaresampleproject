package com.factory;
import com.persistence.AccountDao;
import com.model.Account;
import com.persistence.DbConnection;
import java.util.*;
public class AccountFactory {
	
	//Database Connection 
	private static AccountDao dao() {
    	DbConnection db = new DbConnection();
    	return db.getConnect().onDemand(AccountDao.class);
  	}
	
	//Create Account, Account must be created only if amount it > 500
	public static String createAccount(int accNumber,String name, float amount){
		
	return null;		
	}

	//Withdraw the amount, maintain minimum balance 500
	public static String withdrawAmount(int id, float amount){

	return null;		
	}

	//Deposite the amount, write business method to deposite the amount 
	
	
	
	//display balance amount based upon the account number 
	public static Account balanceCheck() {
    	
	return null;
  	}
}