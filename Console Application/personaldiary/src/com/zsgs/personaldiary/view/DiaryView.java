package com.zsgs.personaldiary.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.zsgs.personaldiary.viewmodel.DiaryViewModel;

public class DiaryView {
    private DiaryViewModel diaryViewModel;
    Scanner scanner = new Scanner(System.in);
    String targetDate;
    int entryIndex;

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
            System.out.println("4. Editing an diary");
            System.out.println("0. Exit");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Enter your diary entry");
                        String entryText = scanner.nextLine();
                        System.out.println("Do you want to encrypt your entry? (Y/N)");
                        String encryptChoice = scanner.nextLine();
                        if (encryptChoice.equalsIgnoreCase("Y")) {
                            String encryptedEntry = diaryViewModel.encryptEntry(entryText);
                            diaryViewModel.addEntry(encryptedEntry,true);
                        } else {
                            diaryViewModel.addEntry(entryText,false);
                        }
                        diaryViewModel.saveEntriesToFile();
                        break;
                    case 2:
                        System.out.println("Your Diary Entries:");
                        diaryViewModel.viewEntries();
                        break;
                    case 3:
                        System.out.println("Enter the date (dd-MM-yyyy) to view entries:");
                        targetDate = scanner.nextLine();
                        diaryViewModel.viewEntriesForDate(targetDate);
                        break;
                    case 4:
                        System.out.println("Do you know the exact date for editing");
                        System.out.println("1. Yes\n2. No, show all entries");
                        int editChoice = scanner.nextInt();
                        scanner.nextLine();
                        switch (editChoice) {
                            case 1:
                                targetDate = getTargetDate();
                                diaryViewModel.viewEntriesForDate(targetDate);
                                entryIndex = getEntryIndexForDate(targetDate);
                                scanner.nextLine();
                                diaryViewModel.editEntry(entryIndex);
                                break;
                            case 2:
                                diaryViewModel.viewEntries();
                                targetDate = getTargetDate();
                                diaryViewModel.viewEntriesForDate(targetDate);
                                entryIndex = getEntryIndexForDate(targetDate);
                                scanner.nextLine();
                                diaryViewModel.editEntry(entryIndex);
                                break;
                            default:
                                System.out.println("Invalid choice. Please enter a valid option.");
                                break;
                        }
                        break;
                    case 0:

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
        System.out.println("Enter the date (dd-MM-yyyy) to edit entries:");
        System.out.println(errorMessage);
    }

    private String getTargetDate() {
        System.out.println("Enter the date (dd-MM-yyyy) to edit entries:");
        return scanner.nextLine();
    }

    private int getEntryIndexForDate(String targetDate) {
        System.out.println("Enter the number of the entry to edit:");
        return scanner.nextInt();
    }

    public String printSelectedEntry(String selectedEntry) {
        System.out.println("Editing entry: " + selectedEntry);
        System.out.println("Enter the updated text:");
        String updatedEntry = scanner.nextLine();
        return updatedEntry;
    }
}
