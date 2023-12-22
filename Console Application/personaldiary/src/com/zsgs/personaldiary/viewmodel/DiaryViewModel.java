package com.zsgs.personaldiary.viewmodel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import com.zsgs.personaldiary.repository.DiaryRepository;
import com.zsgs.personaldiary.view.DiaryView;

public class DiaryViewModel {
    private DiaryView diaryView;

    public DiaryViewModel(DiaryView diaryView) {
        this.diaryView = diaryView;
        DiaryRepository.getInstance().loadEntriesFromFile();
    }

    public void addEntry(String entryText) {
        LocalDateTime currDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
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
                String date = parts[0];
                String text = parts[1];
                System.out.println("\nDate: " + date);
                System.out.println("  " + text);
            }
        }
    }

    public void viewEntriesForDate(String targetDate) {
        System.out.println("Entries for " + targetDate + ":");
        boolean found = false;
        for (String entry : DiaryRepository.getInstance().getdiaryEntries()) {
            String[] parts = entry.split(" - ");
            String date = parts[0];

            if (date.startsWith(targetDate)) {
                found = true;
                System.out.println("- " + entry);
            }
        }
        if (!found) {
            System.out.println("No entries found for given date");
        }
    }

    public void saveEntriesToFile() {
        DiaryRepository.getInstance().saveEntriesToFile();
    }

}
