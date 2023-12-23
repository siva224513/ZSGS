package com.zsgs.dungeongame;

import java.util.Arrays;

public class Levels {
    public void level1(int box[][], int adventurerPositionRow, int adventurerPositionColumn, int goldPostionRow,
            int goldPostionColumn) {

        // for (int b[] : box) {
        //     Arrays.fill(b, 1);
        // }
        // box[adventurerPositionRow][adventurerPositionColumn]=0;
        // box[goldPostionRow][goldPostionColumn]=100;
        // System.out.println(Arrays.deepToString(box));
        System.out.println("Minimum Number of Steps");
        System.out.println(Math.abs(adventurerPositionRow-goldPostionRow)+Math.abs(adventurerPositionColumn-goldPostionColumn));

    }
}
