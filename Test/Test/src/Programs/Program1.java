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
        }

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

        
        
    
  
}
