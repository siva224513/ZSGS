package Programs;

import java.util.Scanner;
public class Program1 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("enter the number");
        int n=scan.nextInt();
      
        int[][] arr = new int[n][n];
        int value=1;  //count
        int left=0,right=n-1;
        int top=0,down=n-1;
        int ld= (int) Math.pow(n,2);
        for(int i=n-1;i>0;i--){
            ld = ld -i;
        }
        while(value<=ld){
            for(int i=left;i<=right;i++){
                arr[i][top]=value;
                value++;
            }
            top++;right--;
            for(int i=right;i>=left;i--){
                arr[i][down]=value;
                value++;
            }
            down--;
            for(int i=down;i>=top;i--){
                arr[left][i]=value;
                value++;
            }
            left++;right--;
        }

        for(int i=0;i<n;i++){
            for(int space=0;space<i;space++){
                System.out.print("  ");
            }

            for(int j=0;j<n;j++){
                if(arr[i][j]==0)
                    continue;
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
   /*Adding this solution on 11/11/23 - saturday

       while(top<=down && left<=right){
          for(int i=top;i<=down;i++){
              arr[i][left+i]=value++;
          }
          left++;
          down--;
          for(int i=down;i>=top;i--){
             arr[i][right]=value++;
          }
          right--;
          for(int i=right;i>=left;i--){
            if(left==i && top!=0){
                break;
            }
             arr[top][i]=value++;
          }
         top++;
         down--;


        for (int i = 0; i < arr.length; i++) {
         for (int j = 0; j < arr[i].length; j++) {
             if (arr[i][j] != 0) {
            System.out.printf("%3d", arr[i][j]);
               } else {
            System.out.print("   ");
             }
            }
           System.out.println();
         }
    }
    * 
    */
}
