package com.zsgs.interviewpanel.dto;

public class Candidate {
    private int candidateId;
	private String name;

	public int getCandidateId(){
		return candidateId;
	}
	public void setCadidateId(int candidateId){
		this.candidateId=candidateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		
	}
	
}
