package com.cdac.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static com.cdac.utils.DBUtils.*;

import com.cdac.pojos.Candidate;

public class CandidateDaoImpl implements CandidateDao {
	//state
	private Connection connection;
	private PreparedStatement pst1,pst2;
	
	public CandidateDaoImpl() throws SQLException{
		//get cn
		connection=getConnection();
		//pst1
		pst1=connection.prepareStatement("select * from candidates");
		//pst2
		pst2=connection.prepareStatement("update candidates set votes=votes+1 where id=?");
		System.out.println("candidate dao created !");
	}

	@Override
	public List<Candidate> getAllCandidates() throws SQLException {
		List<Candidate> candidates=new ArrayList<>();
		try(ResultSet rst=pst1.executeQuery())
		{
			while(rst.next())
				candidates.add(new Candidate(rst.getInt(1), 
						rst.getString(2), rst.getString(3),rst.getInt(4)));
		}
		return candidates;
	}
	

	@Override
	public String incrementVotes(int candidateId) throws SQLException {
		//set In param : candidate id
		pst2.setInt(1, candidateId);
		int rowCount=pst2.executeUpdate();
		if(rowCount==1)
			return "Incremented votes !";
		return "Incrementing votes failed !!!!!";
	}

	@Override
	public void cleanUp() throws SQLException {
		if(pst1 != null)
			pst1.close();
		if(pst2 != null)
			pst2.close();
		System.out.println("candidate dao cleaned up !");
		
	}
	
	

}
