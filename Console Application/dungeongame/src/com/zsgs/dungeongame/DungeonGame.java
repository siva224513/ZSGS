package com.zsgs.dungeongame;

import java.util.Scanner;

public class DungeonGame {
    public static Scanner scanner = new Scanner(System.in);
    public static int row = 0, column = 0, adventurerPositionColumn = 0, adventurerPositionRow = 0, goldPostionRow = 0,
            goldPostionColumn = 0, monsterPositionRow = 0, monsterPositionColumn = 0;

    public static void main(String[] args) throws Exception {
        Levels levels = new Levels();

        System.out.println("Welcome to DungeonGame");
        System.out.println(
                "1.Adventurer and Gold\n2.Adventurer and gold with monster\n3.Adventurer and gold with monster(Path)");

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

                int path=levels.level2(row, column, adventurerPositionRow - 1, adventurerPositionColumn - 1, goldPostionRow - 1,
                        goldPostionColumn - 1, monsterPositionRow - 1, monsterPositionColumn - 1);
                if(path!=-1){
                    System.out.println("Minimum Number of steps"+path);
                }
                else{
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
                levels.level3(row, column, adventurerPositionRow , adventurerPositionColumn , goldPostionRow ,
                        goldPostionColumn , monsterPositionRow , monsterPositionColumn );
                break;

            default:
                break;
        }
    }
}
