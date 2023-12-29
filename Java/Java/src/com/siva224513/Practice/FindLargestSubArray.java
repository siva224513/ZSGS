
package com.siva224513.Practice;
import java.util.*;
/*
Given an array containing only 0s and 1s, find the largest subarray which contains equal no of 0s and 1s. The expected time complexity is O(n).

Sample 1 : Input: arr[] = {1, 0, 1, 1, 1, 0, 0}

Output: {0, 1, 1, 1, 0, 0}
 */
public class FindLargestSubArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        FindLargestSubArray f =new FindLargestSubArray();
        int n = scan.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }
       f. findLargestSubArray(arr,n);
       
    }
    void findLargestSubArray(int a[],int n){
        int maxlength=0,end=-1,sum=0;
        HashMap<Integer,Integer> map =new HashMap<>();
        for(int i=0;i<n;i++){
            if(a[i]==0){
                a[i]=-1;
            }
            sum+=a[i];
            if(sum==0){
                maxlength=i+1;
                end=i; 
            }
            if(map.containsKey(sum)){
               if(maxlength<i-map.get(sum)){
                maxlength = i-map.get(sum);
                end =i;
               }
            }
            else{
            map.put(sum,i);
            }
        }
        int start = (end-maxlength)+1;
        if(end==-1){
            System.out.println("No such subarray");
        }else{
            for(int i=start;i<=end;i++){
                if(a[i]==-1){
                    System.out.print("0 ");
                }
                else{
                    System.out.print(a[i]+" ");
                }
            }
        }
    }
}
