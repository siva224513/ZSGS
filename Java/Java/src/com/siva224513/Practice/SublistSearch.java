package com.siva224513.Practice;

import java.util.ArrayList;
import java.util.Scanner;

public class SublistSearch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter the size of the first ArrayList");
        int size1 = scan.nextInt();
        System.out.println("enter the elements for first ArrayList");
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            list1.add(scan.nextInt());
        }
        System.out.println("enter the size of the second ArrayList");
        int size2 = scan.nextInt();
        System.out.println("enter the elements for second ArrayList");
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < size2; i++) {
            list2.add(scan.nextInt());
        }
        System.out.println("List-1 " + list1);
        System.out.println("List-2 " + list2);
        boolean result = isSubList(list1, list2, size1, size2);
        if(result){
            System.out.println("List-2 is a sublist of list-1");
        }
        else{
            System.out.println("List-2 is not a sublist of list-1");
        }

    }

    private static boolean isSubList(ArrayList<Integer> list1, ArrayList<Integer> list2, int n, int m) {
          for(int i=0;i<n-m;i++){
            if(list1.subList(i, i+m).equals(list2)){
                return true;
            }
          }
          return true;
    }
}
