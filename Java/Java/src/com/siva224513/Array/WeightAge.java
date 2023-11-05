package com.siva224513.Array;
import java.util.ArrayList;
//import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;



public class WeightAge {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        System.out.println("Enter Number of the elements");
        int n=scan.nextInt();
        System.out.println("Enter "+n+"elements");
        int arr[]=new int[n];
        ArrayList<Integer> list=new ArrayList<>(n);
        for(int i=0;i<n;i++){
            arr[i]=scan.nextInt();
            list.add(arr[i]);
        }
       // System.out.println(list);
       Collections.sort(list,(a,b)->{
         int x=findWeight(a);
         int y=findWeight(b);
         if(x==y){
            return b-a;
         }
         return y-x;
       });


       for(int i:list){
        System.out.println("<"+i+","+findWeight(i)+">");
       }
       

       
    }
    public static int findWeight(int n){
        int weight=0;
        if(isSquare(n)){
           weight+=5;
        }
        if(n%4==0 && n%6==0){
            weight+=4;
        }
        if(n%2==0){
            weight+=3;
        }
        return weight;
    }
    public static boolean isSquare(int n){
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}


