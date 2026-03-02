package com.cdac.dao;

import java.sql.SQLException;
import java.util.List;

import com.cdac.pojos.Candidate;

public interface CandidateDao {
//add a method to get all candidates
	List<Candidate> getAllCandidates() throws SQLException;

	// add a method to increment votes
	String incrementVotes(int candidateId) throws SQLException;
	//add a method to get top 2 candidates
	List<Candidate> getTop2Candidates() throws SQLException;

	// add a method to clean up DB resources;
	void cleanUp() throws SQLException;

}
