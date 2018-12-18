package com;
import java.util.*;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface EmployeeDao {
    
    @SqlQuery("SELECT * FROM EMPLOYEE")
    @Mapper(EmployeeMapper.class)
    public List<Employee> allEmployeeDetails(); 

    @SqlQuery("SELECT * FROM EMPLOYEE where id = :empId")
    @Mapper(EmployeeMapper.class)
    public Employee empById(@Bind("empId") int eid); 
    
    @SqlUpdate("insert into employee values(:empid,:empname,:empsalary)")
    int insertEmp(@Bind("empid") int id,@Bind("empname") String name,@Bind("empsalary") float salary);
	
   @SqlUpdate("delete from employee where id = :empId")
    int deleteEmp(@Bind("empId") int id);
   
   @SqlUpdate("update employee set salary = :empSalary where id = :empId")
   int updateEmp(@Bind("empId")int id, @Bind("empSalary") float salary);
   
}



