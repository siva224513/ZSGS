package com.siva224513.Practice;

import java.util.Arrays;
import java.util.Scanner;

public class SuccessiveMaxDiffernece {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SuccessiveMaxDiffernece s = new SuccessiveMaxDiffernece();
        System.out.println("Enter the size of the array");
        int n = scan.nextInt();
        System.out.println("Enter " + n + " elements");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        s.maxDifference(arr, n);
    }

    private void maxDifference(int[] arr, int n) {
        if (arr.length < 2) {
            System.out.println("array size is less than 2");
            return;
        }
        Arrays.sort(arr);
        int maxDiff = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            maxDiff = Math.max(maxDiff, arr[i + 1] - arr[i]);
        }
        System.out.println(maxDiff);
    }
}
