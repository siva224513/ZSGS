import java.util.*;

public class Rearrange {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int n=scan.nextInt();
        System.out.println("Enter "+n+" elements");
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }
        System.out.println("Print Array Before Sorting:");
        printArray(arr,n);
        Arrays.sort(arr);
        System.out.println("Print Array After Sorting");
        printArray(arr,n);
        rearrangeArray(arr,n);
        System.out.println("After Modification");
        printArray(arr, n);
        scan.close();
        
        
    }
    public static void rearrangeArray(int arr[],int n){
        int ind=n-1;
        if(ind%2!=0)ind--;
        for(int i=ind;i>0;i-=2){
            int curr=arr[0];
            for(int j=1;j<=i;j++){
                arr[j-1]=arr[j];
            }
            arr[i]=curr;
        }
    }
    public static void printArray(int a[],int n){
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println(" ");
    }
}
