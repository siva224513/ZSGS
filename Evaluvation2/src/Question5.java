import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Question5 obj =new Question5();
        System.out.println("Enter the String:");
        String input= scan.nextLine();
        int matrix[][]=setMatrix(input);
        
    }

    private static int[][] setMatrix(String input) {
          int row=Math.sqrt(input.length()/2);
    }
}
