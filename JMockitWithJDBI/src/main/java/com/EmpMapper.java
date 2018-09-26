package com;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

public class EmpMapper implements ResultSetMapper<Emp> {
	  public final Emp map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException 			{
  	return new Emp(rs.getInt(1), rs.getString(2), rs.getFloat(3));
  	}
}