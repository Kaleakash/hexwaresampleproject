package com;
import org.skife.jdbi.v2.DBI;
public class DBConnection {
    public DBI getConnection() throws Exception{
        
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver Loaded...");
        DBI dbi =new DBI("jdbc:mysql://localhost:3306/test","root","root");
        System.out.println("Establish the connection...");
        return dbi;
    }
}