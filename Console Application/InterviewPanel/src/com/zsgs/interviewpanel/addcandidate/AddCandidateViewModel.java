package com.zsgs.interviewpanel.addcandidate;

import com.zsgs.interviewpanel.dto.Candidate;
import com.zsgs.interviewpanel.repository.InterviewPanelRepository;

class AddCandidateViewModel {

	private AddCandidate addCandidate;
	
	public AddCandidateViewModel(AddCandidate addCandidate){
		this.addCandidate = addCandidate;
	}
	
	public void validate(Candidate candidate) {
		if(candidate.getName().length()>=3&&candidate.getName().length()<50) {
			//insert into DB
			InterviewPanelRepository.getInstance().insertCandidate(candidate);
			
			this.addCandidate.onSuccess();
		}else {
			 
			this.addCandidate.showError("Invalid Name - Name length should be min 3 and Max 50");
		}
		
	}

}
