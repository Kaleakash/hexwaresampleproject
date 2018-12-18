package com;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

public class EmployeeMapper implements ResultSetMapper<Employee> {
   
 public final Employee map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
        return new Employee(rs.getInt("id"), rs.getString(2), rs.getFloat(3)); 
    }
}