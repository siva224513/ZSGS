package com.zsgs.dungeongame;

import java.util.Scanner;

public class DungeonGame {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Levels levels = new Levels();

        System.out.println("Welcome to DungeonGame");
        System.out.println("1.Adventurer and Gold\n");

        int level = scanner.nextInt();
        switch (level) {
            case 1:
                System.out.println("Dimensions of the dungeon(Row X column):");
                int row = scanner.nextInt();
                int column = scanner.nextInt();
                int box[][] = new int[row][column];
                System.out.println("Enter Position(coordinates) of the adventurer");
                int adventurerPositionRow = scanner.nextInt();
                int adventurerPositionColumn = scanner.nextInt();
                System.out.println("Enter position(coordinates) of the gold");
                int goldPostionRow = scanner.nextInt();
                int goldPostionColumn = scanner.nextInt();
                levels.level1(box, adventurerPositionRow-1, adventurerPositionColumn-1, goldPostionRow-1, goldPostionColumn-1);
                break;

            default:
                break;
        }
    }
}
