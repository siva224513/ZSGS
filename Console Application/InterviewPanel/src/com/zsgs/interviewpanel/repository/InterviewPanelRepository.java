
package com.zsgs.interviewpanel.repository;

import java.util.ArrayList;
import java.util.List;

import com.zsgs.interviewpanel.dto.Candidate;

public class InterviewPanelRepository {
	
	private static InterviewPanelRepository repository;
	private List<Candidate> candidatesList = new ArrayList<Candidate>(); 
	
	private InterviewPanelRepository() {
	
		
	}
	
	public static InterviewPanelRepository getInstance() {
		if(repository == null) {
			repository = new InterviewPanelRepository();
		}
		return repository;
	}

	public void insertCandidate(Candidate candidate) {
		candidatesList.add(candidate);
	}
	
	public List<Candidate> getCandidatesList(){
		return candidatesList;
	}

}
