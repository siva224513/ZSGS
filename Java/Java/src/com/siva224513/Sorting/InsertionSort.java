package com.siva224513.Sorting;

import java.util.Scanner;

public class InsertionSort {
     public static void main(String[] args) {
       Scanner scan=new Scanner(System.in);
       int n=scan.nextInt();
       int a[]=new int[n];
       for(int i=0;i<n;i++){
         a[i]=scan.nextInt();
       }
       InsertionSort i =new InsertionSort();
       i.insertionSort(a, n);
       i.print(a, n);
       
    }
    public void insertionSort(int a[],int n){
        for(int i=1;i<n;i++){
            int key = a[i];
            int j=i-1;
             
            while(j>=0 && a[j]>key){
                
                a[j+1]=a[j];
                j--;
                
               
            }
            a[j+1]=key;
            
        }
    }


    public void print(int a[],int n){
        for(int i=0;i<n;i++){
           System.out.print(a[i]+" ");
       }
       System.out.println();
       
   }
}
