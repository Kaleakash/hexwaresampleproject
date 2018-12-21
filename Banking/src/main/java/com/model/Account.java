package com.model;
import org.skife.jdbi.v2.DBI;
import java.util.*;
public class Account {
	private int accNumber;
	private String name;
	private float amount;
	
	public Account(int accNumber, String name, float amount){
		this.accNumber = accNumber;
		this.name = name;
		this.amount = amount;
	}
//Writer default constructor, setter/getter, equals and hashCode
	
		
}