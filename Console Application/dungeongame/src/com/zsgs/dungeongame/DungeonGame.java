package com.zsgs.dungeongame;

import java.util.ArrayList;
import java.util.Scanner;

public class DungeonGame {
    public static Scanner scanner = new Scanner(System.in);
    public int row = 0, column = 0, adventurerPositionColumn = 0, adventurerPositionRow = 0, goldPostionRow = 0,
            goldPostionColumn = 0, monsterPositionRow = 0, monsterPositionColumn = 0, triggerRow = 0, triggerColumn = 0,
            pitRow = 0, pitColumn = 0, numberOfPits;
    public ArrayList<int[]> list = null;

    public static void main(String[] args) {
        DungeonGame d = new DungeonGame();
        d.run();
    }

    void run() {
        Levels levels = new Levels();

        System.out.println("Welcome to DungeonGame");
        System.out.println(
                "1.Adventurer and Gold\n2.Adventurer and gold with monster\n3.Adventurer and gold with monster(Path)\n4.Adventurer and gold with (monster X trigger)\n5.Adventurer and gold with pit\n6.Adventurer and gold with (Monster + Pit)\n7.Adventurer and gold with (Monster+pit) X (Trigger)");

        int level = scanner.nextInt();
        switch (level) {
            case 1:
                System.out.println("Dimensions of the dungeon(Row X column):");
                row = scanner.nextInt();
                column = scanner.nextInt();
                System.out.println("Enter Position(coordinates) of the adventurer");
                adventurerPositionRow = scanner.nextInt();
                adventurerPositionColumn = scanner.nextInt();
                System.out.println("Enter position(coordinates) of the gold");
                goldPostionRow = scanner.nextInt();
                goldPostionColumn = scanner.nextInt();

                levels.level1(row, column, adventurerPositionRow - 1, adventurerPositionColumn - 1, goldPostionRow - 1,
                        goldPostionColumn - 1);
                break;
            case 2:
                System.out.println("Dimensions of the dungeon(Row X column):");
                row = scanner.nextInt();
                column = scanner.nextInt();
                System.out.println("Enter Position(coordinates) of the adventurer");
                adventurerPositionRow = scanner.nextInt();
                adventurerPositionColumn = scanner.nextInt();
                System.out.println("Enter position of the monster");
                monsterPositionRow = scanner.nextInt();
                monsterPositionColumn = scanner.nextInt();
                System.out.println("Enter position(coordinates) of the gold");
                goldPostionRow = scanner.nextInt();
                goldPostionColumn = scanner.nextInt();

                int path = levels.level2(row, column, adventurerPositionRow - 1, adventurerPositionColumn - 1,
                        goldPostionRow - 1,
                        goldPostionColumn - 1, monsterPositionRow - 1, monsterPositionColumn - 1);
                if (path != -1) {
                    System.out.println("Minimum Number of steps" + path);
                } else {
                    System.out.println("No possible solution");
                }
                break;

            case 3:
                System.out.println("Dimensions of the dungeon(Row X column):");
                row = scanner.nextInt();
                column = scanner.nextInt();
                System.out.println("Enter Position(coordinates) of the adventurer");
                adventurerPositionRow = scanner.nextInt();
                adventurerPositionColumn = scanner.nextInt();
                System.out.println("Enter position of the monster");
                monsterPositionRow = scanner.nextInt();
                monsterPositionColumn = scanner.nextInt();
                System.out.println("Enter position(coordinates) of the gold");
                goldPostionRow = scanner.nextInt();
                goldPostionColumn = scanner.nextInt();
                int path1 = levels.level2(row, column, adventurerPositionRow - 1, adventurerPositionColumn - 1,
                        goldPostionRow - 1,
                        goldPostionColumn - 1, monsterPositionRow - 1, monsterPositionColumn - 1);
                if (path1 != -1) {
                    levels.level3(row, column, adventurerPositionRow, adventurerPositionColumn, goldPostionRow,
                            goldPostionColumn, monsterPositionRow, monsterPositionColumn);
                } else {
                    System.out.println("no possible solution");
                }
                break;
            case 4:
                System.out.println("Dimensions of the dungeon(Row X column):");
                row = scanner.nextInt();
                column = scanner.nextInt();
                System.out.println("Enter Position(coordinates) of the adventurer");
                adventurerPositionRow = scanner.nextInt();
                adventurerPositionColumn = scanner.nextInt();
                System.out.println("Enter position of the monster");
                monsterPositionRow = scanner.nextInt();
                monsterPositionColumn = scanner.nextInt();
                System.out.println("Enter position of the trigger");
                triggerRow = scanner.nextInt();
                triggerColumn = scanner.nextInt();
                System.out.println("Enter position(coordinates) of the gold");
                goldPostionRow = scanner.nextInt();
                goldPostionColumn = scanner.nextInt();
                levels.level4(row, column, adventurerPositionRow - 1, adventurerPositionColumn - 1, goldPostionRow - 1,
                        goldPostionColumn - 1, monsterPositionRow - 1, monsterPositionColumn - 1, triggerRow - 1,
                        triggerColumn - 1);
                break;
            case 5:
                System.out.println("Dimensions of the dungeon(Row X column):");
                row = scanner.nextInt();
                column = scanner.nextInt();
                System.out.println("Enter Position(coordinates) of the adventurer");
                adventurerPositionRow = scanner.nextInt();
                adventurerPositionColumn = scanner.nextInt();
                System.out.println("Enter position(coordinates) of the gold");
                goldPostionRow = scanner.nextInt();
                goldPostionColumn = scanner.nextInt();
                System.out.println("Enter the number of pits");
                numberOfPits = scanner.nextInt();
                list = new ArrayList<>();
                for (int i = 0; i < numberOfPits; i++) {
                    System.out.println("Enter position of the pits:");
                    pitRow = scanner.nextInt();
                    pitColumn = scanner.nextInt();
                    list.add(new int[] { pitRow, pitColumn });

                }

                levels.level5(row, column, adventurerPositionRow - 1, adventurerPositionColumn - 1, goldPostionRow - 1,
                        goldPostionColumn - 1, list);
                break;
            case 6:
                System.out.println("Dimensions of the dungeon(Row X column):");
                row = scanner.nextInt();
                column = scanner.nextInt();
                System.out.println("Enter Position(coordinates) of the adventurer");
                adventurerPositionRow = scanner.nextInt();
                adventurerPositionColumn = scanner.nextInt();
                System.out.println("Enter position of the monster");
                monsterPositionRow = scanner.nextInt();
                monsterPositionColumn = scanner.nextInt();
                System.out.println("Enter position(coordinates) of the gold");
                goldPostionRow = scanner.nextInt();
                goldPostionColumn = scanner.nextInt();
                System.out.println("Enter the number of pits");
                numberOfPits = scanner.nextInt();
                list = new ArrayList<>();
                for (int i = 0; i < numberOfPits; i++) {
                    System.out.println("Enter position of the pits:");
                    pitRow = scanner.nextInt();
                    pitColumn = scanner.nextInt();
                    list.add(new int[] { pitRow, pitColumn });

                }

                int minPath = levels.level6(row, column, adventurerPositionRow - 1, adventurerPositionColumn - 1,
                        monsterPositionRow - 1, monsterPositionColumn - 1, goldPostionRow - 1,
                        goldPostionColumn - 1, list);
                if (minPath != -1) {
                    System.out.println("Minimum number of steps :" + minPath);
                } else {
                    System.out.println("No possible solution");
                }
                break;
            case 7:
                System.out.println("Dimensions of the dungeon(Row X column):");
                row = scanner.nextInt();
                column = scanner.nextInt();
                System.out.println("Enter Position(coordinates) of the adventurer");
                adventurerPositionRow = scanner.nextInt();
                adventurerPositionColumn = scanner.nextInt();
                System.out.println("Enter position of the monster");
                monsterPositionRow = scanner.nextInt();
                monsterPositionColumn = scanner.nextInt();
                System.out.println("Enter position of the trigger");
                triggerRow = scanner.nextInt();
                triggerColumn = scanner.nextInt();
                System.out.println("Enter position(coordinates) of the gold");
                goldPostionRow = scanner.nextInt();
                goldPostionColumn = scanner.nextInt();
                System.out.println("Enter the number of pits");
                numberOfPits = scanner.nextInt();
                list = new ArrayList<>();
                for (int i = 0; i < numberOfPits; i++) {
                    System.out.println("Enter position of the pits:");
                    pitRow = scanner.nextInt();
                    pitColumn = scanner.nextInt();
                    list.add(new int[] { pitRow, pitColumn });

                }
                int minPath1 = levels.level6(row, column, adventurerPositionRow - 1, adventurerPositionColumn - 1,
                        monsterPositionRow - 1, monsterPositionColumn - 1, goldPostionRow - 1,
                        goldPostionColumn - 1, list);
                if (minPath1 != -1) {
                    System.out.println("Minimum number of steps :" + minPath1);
                } else if (minPath1 == -1) {

                    levels.level7(row, column, adventurerPositionRow - 1, adventurerPositionColumn - 1,
                            monsterPositionRow - 1, monsterPositionColumn - 1, triggerRow - 1, triggerColumn - 1,
                            goldPostionRow - 1,
                            goldPostionColumn - 1, list);
                } else {
                    System.out.println("No possible solution");
                }

                break;
            default:
                break;
        }
    }
}
