package com.cdac.dao;

import java.sql.*;
import static com.cdac.utils.DBUtils.*;

public class BankAccountDaoImpl implements BankAccountDao {
	private Connection connection;
	private CallableStatement cst1;
	//def ctor
	public BankAccountDaoImpl() throws SQLException{
		// 1. get cn
		connection=openConnection();
		String sql="{call transfer_funds_proc(?,?,?,?,?)}";
		//2 . create CST
		cst1=connection.prepareCall(sql);
		//3. register OUT param
		cst1.registerOutParameter(4,Types.DOUBLE);
		cst1.registerOutParameter(5,Types.DOUBLE);		
		System.out.println("bank account dao created !");
		
	}

	@Override
	public String transferFunds(int srcId, int destId, double transferAmount) throws SQLException {
		// 1. Set IN params (using inherited API from PreparedStatement)
		cst1.setInt(1, srcId);
		cst1.setInt(2, destId);
		cst1.setDouble(3, transferAmount);
		//2.exec stored procedure
		cst1.execute();
		return "Updated src balance "
		+cst1.getDouble(4)+" dest balance"+cst1.getDouble(5);
	}

	@Override
	public void cleanUp() throws SQLException {
		if(cst1 != null)
			cst1.close();
		closeConnection();		
	}
	

}
