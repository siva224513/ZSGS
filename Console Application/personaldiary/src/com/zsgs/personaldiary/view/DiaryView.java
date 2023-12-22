package com.zsgs.personaldiary.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.zsgs.personaldiary.viewmodel.DiaryViewModel;

public class DiaryView {
    private DiaryViewModel diaryViewModel;
    Scanner scanner = new Scanner(System.in);

    public DiaryView() {
        diaryViewModel = new DiaryViewModel(this);
    }

    public void writeDiary() {
        System.out.println("Welcome to your diary");
        boolean exit = false;
        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add an entry");
            System.out.println("2. View all entries");
            System.out.println("3. View entries for a specific date");
            System.out.println("4. Exit");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Enter your diary entry");
                        String entryText = scanner.nextLine();
                        diaryViewModel.addEntry(entryText);
                        break;
                    case 2:
                        System.out.println("Your Diary Entries:");
                        diaryViewModel.viewEntries();
                        break;
                    case 3:
                        System.out.println("Enter the date (yyyy-MM-dd) to view entries:");
                        String targetDate = scanner.nextLine();
                        diaryViewModel.viewEntriesForDate(targetDate);
                        break;
                    case 4:
                        diaryViewModel.saveEntriesToFile();
                        exit = true;
                        System.out.println("Exiting the Personal Diary. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number");
                scanner.next();
            }
        }
    }

    public void onSuccess() {
        System.out.println("Entry added Successfully...");
    }

    public void showError(String errorMessage) {
        System.out.println(errorMessage);
    }
}
