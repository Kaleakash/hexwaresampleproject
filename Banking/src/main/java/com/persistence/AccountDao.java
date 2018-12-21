package com.persistence;
import com.model.Account;
import java.util.*;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface AccountDao {
	
	@SqlQuery("")
	@Mapper(AccountMapper.class)
	public Account balanceCheck(@Bind("accNumber") int accNumber);
	
	@SqlUpdate("insert into account values(:accnum,:name,:amount)")
	public int createAccount(int accnum,String name,float amount);


}