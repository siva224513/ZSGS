package com.zsgs.personaldiary.viewmodel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.zsgs.personaldiary.repository.DiaryRepository;
import com.zsgs.personaldiary.view.DiaryView;

public class DiaryViewModel {
    private DiaryView diaryView;
    private ArrayList<String> list = new ArrayList<>();

    public DiaryViewModel(DiaryView diaryView) {
        this.diaryView = diaryView;
        DiaryRepository.getInstance().loadEntriesFromFile();
    }

    public void addEntry(String entryText) {
        LocalDateTime currDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatterTime = currDateTime.format(formatter);
        String entry = formatterTime + " - " + entryText;
        DiaryRepository.getInstance().addEntry(entry);
        this.diaryView.onSuccess();
    }

    public void viewEntries() {

        if (DiaryRepository.getInstance().getdiaryEntries().isEmpty()) {
            this.diaryView.showError("No entries yet. Start by adding some!");
        } else {

            for (String entry : DiaryRepository.getInstance().getdiaryEntries()) {
                String[] parts = entry.split(" - ");
                if (parts.length >= 2) {
                    String date = parts[0];
                    String text = parts[1];
                    System.out.println("\nDate: " + date);
                    System.out.println("  " + text);
                } else {

                    System.out.println("Invalid entry format: " + entry);
                }
            }
        }
    }

    public void viewEntriesForDate(String targetDate) {
        System.out.println("Entries for " + targetDate + ":");
        boolean found = false;
        int index = 1;
        for (String entry : DiaryRepository.getInstance().getdiaryEntries()) {
            String[] parts = entry.split(" - ");
            String date = parts[0];

            if (date.startsWith(targetDate)) {
                found = true;
                list.add(entry);
                System.out.println(index++ + ". " + entry);
            }
        }
        if (!found) {
            System.out.println("No entries found for given date");
        }
    }

    public void saveEntriesToFile() {
        DiaryRepository.getInstance().saveEntriesToFile();
    }

    public void editEntry(int entryIndex) {
        if (entryIndex >= 1 && entryIndex <= list.size()) {
            String selectedEntry = list.get(entryIndex - 1);

            String updatedText = this.diaryView.printSelectedEntry(selectedEntry);

            String[] parts = selectedEntry.split(" - ");
            String updatedEntry = parts[0] + " - " + updatedText;

            ArrayList<String> diaryEntries = DiaryRepository.getInstance().getdiaryEntries();
            for (int i = 0; i < diaryEntries.size(); i++) {
                if (diaryEntries.get(i).equals(selectedEntry)) {
                    diaryEntries.set(i, updatedEntry);
                    break;
                }
            }

            DiaryRepository.getInstance().saveEntriesToFile();
            System.out.println("Entry updated successfully!");
        } else {
            System.out.println("Invalid entry number.");
        }

    }

}
