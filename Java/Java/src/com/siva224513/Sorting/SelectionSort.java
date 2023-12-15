package com.siva224513.Sorting;

import java.util.Scanner;

public class SelectionSort {
     public static void main(String[] args) {
       Scanner scan=new Scanner(System.in);
       int n=scan.nextInt();
       int a[]=new int[n];
       for(int i=0;i<n;i++){
         a[i]=scan.nextInt();
       }
       SelectionSort s=new SelectionSort();
       s.selectionSort(a, n);
       s.print(a, n);
       
    }
    public void selectionSort(int a[],int n){
        for(int i=0;i<n;i++){
            int min=i;
            for(int j=i+1;j<n;j++){
                if(a[j]>a[min]){
                    min=j;
                }
            }
            int temp=a[i];
            a[i]=a[min];
            a[min]=temp;
        }
    }
    public void print(int a[],int n){
        for(int i=0;i<n;i++){
           System.out.print(a[i]+" ");
       }
       System.out.println();
       
   }
}
