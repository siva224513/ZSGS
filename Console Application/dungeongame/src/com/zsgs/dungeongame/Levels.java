package com.zsgs.dungeongame;

import java.util.Arrays;

public class Levels {
    public void level1(int row, int column, int adventurerPositionRow, int adventurerPositionColumn, int goldPostionRow,
            int goldPostionColumn) {

        // for (int b[] : box) {
        // Arrays.fill(b, 1);
        // }
        // box[adventurerPositionRow][adventurerPositionColumn]=0;
        // box[goldPostionRow][goldPostionColumn]=100;
        // System.out.println(Arrays.deepToString(box));
        System.out.println("Minimum Number of Steps");
        System.out.println(Math.abs(adventurerPositionRow - goldPostionRow)
                + Math.abs(adventurerPositionColumn - goldPostionColumn));

    }

    public void level2(int row, int column, int adventurerPositionRow, int adventurerPositionColumn, int goldPostionRow,
            int goldPostionColumn, int monsterPositionRow, int monsterPositionColumn) {

        int monsterMinPath = Math.abs(monsterPositionRow - goldPostionRow)
                + Math.abs(monsterPositionColumn - goldPostionColumn);
        int adventurerMinPath = Math.abs(adventurerPositionRow - goldPostionRow)
                + Math.abs(adventurerPositionColumn - goldPostionColumn);
        if (adventurerMinPath <= monsterMinPath) {
            System.out.println("Minimum number of steps: " + adventurerMinPath);
        } else {
            System.out.println("No possible solution");
        }
    }
}
