package com;
import java.util.*;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
public interface EmpDao {
	@SqlQuery("select * from emp")
	@Mapper(EmpMapper.class)
	public List<Emp> getAllEmployees();
	
	@SqlUpdate("insert into emp values(:id,:name,:salary)")
	public int addEmpDao(@Bind("id") int id, @Bind("name") String name,@Bind("salary") float salary);

	@SqlUpdate("delete from emp where id = :id")
	public int deleteEmpDao(@Bind("id") int id);

	@SqlUpdate("update emp set salary = salary + :salary where id = :id")
	public int incrementEmpSalary(@Bind("id") int id, @Bind("salary") float salary);


	@SqlUpdate("update emp set salary = salary - :salary where id = :id")
	public int decrementEmpSalary(@Bind("id") int id, @Bind("salary") float salary);


	@SqlQuery("select * from emp where id = :id")
	@Mapper(EmpMapper.class)	
	public Emp displayOneEmp(@Bind("id") int id);		
}