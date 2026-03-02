package com.cdac.beans;

import java.sql.SQLException;
import java.util.List;

import com.cdac.dao.CandidateDao;
import com.cdac.dao.CandidateDaoImpl;
import com.cdac.pojos.Candidate;

public class CandidateBean {
	private CandidateDao candidateDao;

	public CandidateBean() throws SQLException {
		// create dao instance
		candidateDao = new CandidateDaoImpl();
		System.out.println("candidate bean created !");
	}

	// B.L method to get top 2 candidates
	public List<Candidate> getCandidates() throws SQLException {
		System.out.println("in get top 2 candidates");
		return candidateDao.getTop2Candidates();
	}

}
