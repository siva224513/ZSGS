package com.siva224513.Sorting;

import java.util.Scanner;

public class BubbleSort{
    public static void main(String[] args) {
       Scanner scan=new Scanner(System.in);
       int n=scan.nextInt();
       int a[]=new int[n];
       for(int i=0;i<n;i++){
         a[i]=scan.nextInt();
       }
       BubbleSort b=new BubbleSort();
       b.bubbleSort(a, n);
       b.print(a, n);

    }

    public void bubbleSort(int a[],int n){
        boolean swapped;
        for(int i=0;i<n-1;i++){
            swapped=false;
            for(int j=0;j<n-i-1;j++){
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                    swapped=true;
                }
                 print(a,n);
            }
            if(!swapped){
                break;
            }
           
            System.out.println();
        }
    }
    

    public void print(int a[],int n){
        for(int i=0;i<n;i++){
           System.out.print(a[i]+" ");
       }
       System.out.println();
       
   }
}