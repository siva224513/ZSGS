package com.siva224513.Array.BinarySearch;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        System.out.println("Enter the Array size: ");
        int length=scan.nextInt();
        System.out.println("Enter "+length+" elements with space");
        int arr[]=new int[length];
        for(int i=0;i<length;i++){
            arr[i]=scan.nextInt();
        }
        System.out.println("Enter the value you want to find");
        int x=scan.nextInt();
        int result=binarySearch(arr,length,x);
        if(result==-1){
            System.out.println("Element Not found");
        }
        else{
            System.out.println("Element found in index "+ result);
        }
        
    }
    public static int binarySearch(int arr[],int n,int x){
        int left=0,right=n-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]==x){
                return mid;
            }
            else if(arr[mid]>x){
                right=mid-1;
            }
            else if(arr[mid]<x){
                left=mid+1;
            }
        }
        return -1;
    }
}
