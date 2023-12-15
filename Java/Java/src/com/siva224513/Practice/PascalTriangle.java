package com.siva224513.Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter the row number");
        int row = scan.nextInt();
        PascalTriangle p =new PascalTriangle();
        p.printPascaltriangle(row);

    }

    private void printPascaltriangle(int row) {
      List<List<Integer>> result =new ArrayList<>();
      ArrayList<Integer> currentRow,preRow=null;
      for(int i=0;i<row;i++){
        currentRow=new ArrayList<>();
        for(int j=0;j<=i;j++){
            if(j==0||j==i){
                currentRow.add(1);
            }
            else{
                currentRow.add(preRow.get(j-1)+preRow.get(j));
            }
        }
        preRow=currentRow;
        result.add(currentRow);
      }
       for(List<Integer> list:result){
          for(int i:list){
            System.out.print(i+" ");
          }
          System.out.println();
       }
    }
}
