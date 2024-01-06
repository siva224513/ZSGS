package com.zsgs.personaldiary.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DiaryRepository {
    private static DiaryRepository diaryRepository = null;
    private ArrayList<String> diaryEntries;
    private static final String PATH = "G:/ZSGS/Console Application/personaldiary/src/com/zsgs/personaldiary/repository/diary_entries.txt";
    private static final String FILENAME = "diary_entries.txt";
    private DiaryRepository() {
        diaryEntries = new ArrayList<>();

    }

    public static DiaryRepository getInstance() {
        if (diaryRepository == null) {
            diaryRepository = new DiaryRepository();
        }
        return diaryRepository;
    }

    public void addEntry(String entryString) {
        diaryEntries.add(entryString);
    }

    public ArrayList<String> getdiaryEntries() {
        return diaryEntries;
    }

    public void saveEntriesToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH))) {
            for (String entry : diaryEntries) {
                writer.write(entry + "\n");
            }
            System.out.println("Entries saved to " + FILENAME);
        } catch (IOException e) {
            System.out.println("Error saving entries to file: " + e.getMessage());
        }
    }

    public void loadEntriesFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                diaryEntries.add(line);
            }
            System.out.println("Entries loaded from " + FILENAME);
        } catch (IOException e) {
          
        }
    }
    public void editEntriesInFile(){
       
    }
}
