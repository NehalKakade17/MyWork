package com.cdac.pojos;

//id | name          | party    | votes
public class Candidate {
	private int candidateId;
	private String name;
	private String partyName;
	private int votes;
	public Candidate() {
		// TODO Auto-generated constructor stub
	}
	public Candidate(int candidateId, String name, String partyName, int votes) {
		super();
		this.candidateId = candidateId;
		this.name = name;
		this.partyName = partyName;
		this.votes = votes;
	}
	public int getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", name=" + name + ", partyName=" + partyName + ", votes="
				+ votes + "]";
	}
	
}
