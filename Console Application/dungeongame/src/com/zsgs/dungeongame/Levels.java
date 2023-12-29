package com.zsgs.dungeongame;

import java.util.ArrayList;
import java.util.Arrays;

public class Levels {
    int monsterMinPath = Integer.MAX_VALUE;
    int adventurerMinPath = Integer.MAX_VALUE;
    int triggerMinPath = Integer.MAX_VALUE;

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
                    int step = search(box, i, j, row, column, 0, 'G');
                    System.out.println(step);
                    break;
                }
            }
        }

        // System.out.println("Minimum Number of Steps");
        // System.out.println(Math.abs(adventurerPositionRow - goldPostionRow)
        // + Math.abs(adventurerPositionColumn - goldPostionColumn));

    }

    public int level2(int row, int column, int adventurerPositionRow, int adventurerPositionColumn, int goldPostionRow,
            int goldPostionColumn, int monsterPositionRow, int monsterPositionColumn) {

        char box[][] = new char[row][column];
        for (char c[] : box) {
            Arrays.fill(c, '0');
        }
        box[adventurerPositionRow][adventurerPositionColumn] = 'A';
        box[goldPostionRow][goldPostionColumn] = 'G';
        box[monsterPositionRow][monsterPositionColumn] = 'M';

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (box[i][j] == 'A') {
                    adventurerMinPath = search(box, i, j, row, column, 0, 'G');
                    break;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (box[i][j] == 'M') {
                    monsterMinPath = search(box, i, j, row, column, 0, 'G');
                    break;
                }
            }
        }
        if (adventurerMinPath <= monsterMinPath) {
            return adventurerMinPath;
        } else {
            return -1;
        }
    }

    public void level3(int row, int column, int adventurerPositionRow, int adventurerPositionColumn, int goldPostionRow,
            int goldPostionColumn, int monsterPositionRow, int monsterPositionColumn) {
      
       
            if (adventurerPositionColumn <= goldPostionColumn) {
                while (adventurerPositionColumn < goldPostionColumn) {
                    System.out.println((adventurerPositionRow) + " " + (++adventurerPositionColumn));
                }
            } else {
                while (adventurerPositionColumn > goldPostionColumn) {
                    System.out.println((adventurerPositionRow) + " " + ((--adventurerPositionColumn)));
                }
            }

            if (adventurerPositionRow > goldPostionRow) {
                while (adventurerPositionRow > goldPostionRow) {
                    System.out.println((--adventurerPositionRow) + " " + (adventurerPositionColumn));
                }
            } else {
                while (adventurerPositionRow < goldPostionRow) {
                    System.out.println((++adventurerPositionRow) + " " + (adventurerPositionColumn));
                }
            }
       

    }

    public void level4(int row, int column, int adventurerPositionRow, int adventurerPositionColumn, int goldPostionRow,
            int goldPostionColumn, int monsterPositionRow, int monsterPositionColumn, int triggerRow,
            int triggerColumn) {
        int minPath = level2(row, column, adventurerPositionRow, adventurerPositionColumn, goldPostionRow,
                goldPostionColumn, monsterPositionRow, monsterPositionColumn);
        if (minPath != -1) {
            System.out.println("Minimum number of steps:" + minPath);
        } else {
            char box[][] = new char[row][column];
            for (char c[] : box) {
                Arrays.fill(c, '0');
            }
            box[adventurerPositionRow][adventurerPositionColumn] = 'A';
            box[goldPostionRow][goldPostionColumn] = 'G';
            box[monsterPositionRow][monsterPositionColumn] = 'M';
            box[triggerRow][triggerColumn] = 'T';
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (box[i][j] == 'A') {
                        adventurerMinPath = search(box, i, j, row, column, 0, 'T');
                        System.out.println(adventurerMinPath);
                        break;

                    }
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (box[i][j] == 'T') {
                        triggerMinPath = search(box, i, j, row, column, 0, 'G');
                        System.out.println(triggerMinPath);
                        break;
                    }
                }
            }
            System.out.println("Minimum number of steps: " + (adventurerMinPath + triggerMinPath));
        }
    }

    public void level5(int row, int column, int adventurerPositionRow, int adventurerPositionColumn, int goldPostionRow,
            int goldPostionColumn, ArrayList<int[]> list) {
        char box[][] = new char[row][column];
        for (char c[] : box) {
            Arrays.fill(c, '0');
        }
        box[adventurerPositionRow][adventurerPositionColumn] = 'A';
        box[goldPostionRow][goldPostionColumn] = 'G';
        for (int a[] : list) {
            int i = --a[0];
            int j = --a[1];
            box[i][j] = 'P';

        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (box[i][j] == 'A') {
                    int step = search(box, i, j, row, column, 0, 'G');
                    if (step != Integer.MAX_VALUE) {
                        System.out.println("Minimum number of steps: " + step);
                    } else {
                        System.out.println("No possible solution");
                    }
                    break;
                }
            }
        }

    }

    public int level6(int row, int column, int adventurerPositionRow, int adventurerPositionColumn,
            int monsterPositionRow, int monsterPositionColumn, int goldPostionRow,
            int goldPostionColumn, ArrayList<int[]> list) {

        char box[][] = new char[row][column];
        for (char c[] : box) {
            Arrays.fill(c, '0');
        }
        box[adventurerPositionRow][adventurerPositionColumn] = 'A';
        box[monsterPositionRow][monsterPositionColumn] = 'M';
        box[goldPostionRow][goldPostionColumn] = 'G';
        for (int a[] : list) {
            int i = --a[0];
            int j = --a[1];
            box[i][j] = 'P';

        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (box[i][j] == 'A') {
                    adventurerMinPath = search(box, i, j, row, column, 0, 'G');
                    break;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (box[i][j] == 'M') {
                    monsterMinPath = search(box, i, j, row, column, 0, 'G');
                    break;
                }
            }
        }
        if (adventurerMinPath <= monsterMinPath) {
            return adventurerMinPath;
        } else {
            return -1;
        }

    }

    public void level7(int row, int column, int adventurerPositionRow, int adventurerPositionColumn,
            int monsterPositionRow, int monsterPositionColumn, int triggerRow, int triggerColumn, int goldPostionRow,
            int goldPostionColumn, ArrayList<int[]> newList) {

        

        
            char box[][] = new char[row][column];
            for (char c[] : box) {
                Arrays.fill(c, '0');
            }
            box[adventurerPositionRow][adventurerPositionColumn] = 'A';
            box[goldPostionRow][goldPostionColumn] = 'G';
            box[monsterPositionRow][monsterPositionColumn] = 'M';
            box[triggerRow][triggerColumn] = 'T';
            for (int a[] : newList) {
                // System.out.println(Arrays.toString(a));
                int i = a[0];
                int j = a[1];
                // System.out.println(i+" "+j);
                box[i][j] = 'P';

            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (box[i][j] == 'A') {
                        adventurerMinPath = search(box, i, j, row, column, 0, 'T');
                        System.out.println(adventurerMinPath);
                        break;

                    }
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (box[i][j] == 'T') {
                        triggerMinPath = search(box, i, j, row, column, 0, 'G');
                        System.out.println(triggerMinPath);
                        break;
                    }
                }
            }
            if(adventurerMinPath==Integer.MAX_VALUE){
                System.out.println("No possible solution");
            }
            else{
            System.out.println("Minimum number of steps: " + (adventurerMinPath + triggerMinPath));
            }
        
    }

    private int search(char[][] box, int i, int j, int row, int column, int k, char c) {
        if (i >= row || i < 0 || j < 0 || j >= column || box[i][j] == '*' || (c != 'M' && box[i][j] == 'P'))
            return Integer.MAX_VALUE;
        if (box[i][j] == c) {
            return k;
        }
        char temp = box[i][j];
        box[i][j] = '*';

        int up = search(box, i - 1, j, row, column, k + 1, c);
        int down = search(box, i + 1, j, row, column, k + 1, c);
        int left = search(box, i, j - 1, row, column, k + 1, c);
        int right = search(box, i, j + 1, row, column, k + 1, c);
        box[i][j] = temp;

        int minPath = Math.min(Math.min(up, down), Math.min(left, right));
        return minPath;

    }

}