package com.zsgs.dungeongame;

import java.util.Arrays;

public class Levels {
    public void level1(int row, int column, int adventurerPositionRow, int adventurerPositionColumn, int goldPostionRow,
            int goldPostionColumn) {

        char box[][] = new char[row][column];
        for (char c[] : box) {
            Arrays.fill(c, '0');
        }
        box[adventurerPositionRow][adventurerPositionColumn] = 'A';
        box[goldPostionRow][goldPostionColumn] = 'G';

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (box[i][j] == 'A') {
                    int step = search(box, i, j, row, column, 0);
                    System.out.println(step);
                    break;
                }
            }
        }

        // System.out.println("Minimum Number of Steps");
        // System.out.println(Math.abs(adventurerPositionRow - goldPostionRow)
        // + Math.abs(adventurerPositionColumn - goldPostionColumn));

    }

    public void level2(int row, int column, int adventurerPositionRow, int adventurerPositionColumn, int goldPostionRow,
            int goldPostionColumn, int monsterPositionRow, int monsterPositionColumn) {

        char box[][] = new char[row][column];
        for (char c[] : box) {
            Arrays.fill(c, '0');
        }
        box[adventurerPositionRow][adventurerPositionColumn] = 'A';
        box[goldPostionRow][goldPostionColumn] = 'G';
        box[monsterPositionRow][monsterPositionColumn] = 'M';

        int monsterMinPath = Integer.MAX_VALUE;
        int adventurerMinPath = Integer.MAX_VALUE;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (box[i][j] == 'A') {
                    monsterMinPath = search(box, i, j, row, column, 0);
                    System.out.println(monsterMinPath);
                    break;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (box[i][j] == 'M') {
                    adventurerMinPath = search(box, i, j, row, column, 0);
                    System.out.println(adventurerMinPath);
                    break;
                }
            }
        }
        if (adventurerMinPath <= monsterMinPath) {
            System.out.println("Minimum number of steps: " + adventurerMinPath);
        } else {
            System.out.println("No possible solution");
        }
    }

    public void level3(int row, int column, int adventurerPositionRow, int adventurerPositionColumn, int goldPostionRow,
            int goldPostionColumn, int monsterPositionRow, int monsterPositionColumn) {
         
               
    }


    private int search(char[][] box, int i, int j, int row, int column, int k) {
        if (i >= row || i < 0 || j < 0 || j >= column || box[i][j] == '*' )
            return Integer.MAX_VALUE;
        if (box[i][j] == 'G') {
            return k;
        }
        char temp = box[i][j];
        box[i][j] = '*';
       
        int up = search(box, i - 1, j, row, column, k + 1);
        int down = search(box, i + 1, j, row, column, k + 1);
        int left = search(box, i, j - 1, row, column, k + 1);
        int right = search(box, i, j + 1, row, column, k + 1);
        box[i][j] = temp;
       
        
        int minPath = Math.min(Math.min(up, down), Math.min(left, right));
         return minPath;
        
    }

}
