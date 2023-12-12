package com.zsgs.interviewpanel;

import java.util.Scanner;

import com.zsgs.interviewpanel.addcandidate.AddCandidate;

public class InterviewPanel {

	public static void main(String[] args) {
		InterviewPanel interviewPanel = new InterviewPanel();
		interviewPanel.init();
	}

	private void init() {
		System.out.println("1. Add Candidate\n2.View Candidate");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		switch(choice) {
			
		case 1:
			AddCandidate addCandidate = new AddCandidate();
			addCandidate.getCandidateInfo();
			break;


		}
	}

}
