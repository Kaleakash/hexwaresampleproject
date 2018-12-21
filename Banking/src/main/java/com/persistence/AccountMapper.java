package com.persistence;
import com.model.Account;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

public class AccountMapper implements ResultSetMapper<Account> {
	  public final Account map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException 			
	{
  	return new Account(rs.getInt(""), rs.getString(""), rs.getFloat(""));
  	}
}