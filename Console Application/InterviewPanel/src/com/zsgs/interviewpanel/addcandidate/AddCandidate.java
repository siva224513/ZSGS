package com.zsgs.interviewpanel.addcandidate;

import java.util.Scanner;

import com.zsgs.interviewpanel.dto.Candidate;

public class AddCandidate {
	private AddCandidateViewModel addCandidateViewModel;  

	public AddCandidate(){
		addCandidateViewModel = new AddCandidateViewModel(this);
	}
	
	public void getCandidateInfo() {
		
		Scanner sc = new Scanner(System.in);
		Candidate candidate = new Candidate();
		System.out.println("Enter Candidate name:");
		candidate.setName(sc.nextLine());
		addCandidateViewModel.validate(candidate);
		
	}

	public void onSuccess() {
		System.out.println("Inserted Successfully");

	}

	public void showError(String errorMessage) {
		System.out.println(errorMessage);
	}
}
