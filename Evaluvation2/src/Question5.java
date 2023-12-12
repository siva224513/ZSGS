import java.util.Arrays;
import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Question5 obj = new Question5();
        System.out.println("Enter the String:");
        String input = scan.nextLine();
        char matrix[][] = obj.convertToMatrix(input);
        obj.printMatrix(matrix);
        System.out.println("Enter the word you want to search");
        String word = scan.nextLine();
        int result[][]=obj.findWord(matrix, word);
        System.out.println(Arrays.deepToString(result));

    }

    private int[][] findWord(char[][] matrix, String word) {
        int indices[][] = new int[2][2];
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(matrix[i][j]==word.charAt(0)){
                    if(search(matrix,word,i,j,row,col,0,indices)){
                        return indices;
                    }
                }
            }
        }
        return new int[][]{{-1,-1},{-1,-1}};
    }
    private boolean search(char matrix[][],String word,int i,int j,int row,int col,int ind,int[][] indices){
        if(i<0||col<0||i==row||j==col||matrix[i][j]!=word.charAt(ind)||matrix[i][j]=='*'){
            return false;
        }
        if(ind==word.length()-1){
           indices[1]=new int[]{i,j};
           return true;
        }
        char c=matrix[i][j];
        matrix[i][j]='*';
        //top
        if(search(matrix, word, i-1, j, row, col, ind+1, indices)){
             indices[0]=new int[]{i,j};
             return true;
        }
        //right
        if(search(matrix, word, i, j+1, row, col, ind+1, indices)){
             indices[0]=new int[]{i,j};
             return true;
        }
        //down
        else if(search(matrix, word, i+1, j, row, col, ind+1, indices)){
             indices[0]=new int[]{i,j};
             return true;
        }
        //left
        if(search(matrix, word, i, j-1, row, col, ind+1, indices)){
             indices[0]=new int[]{i,j};
             return true;
        }
        matrix[i][j]=c;
        return false;
    }

    private char[][] convertToMatrix(String input) {
        int row = 8;
        int col = 5;
        
        char matrix[][] = new char[row][col];
        int ind = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (ind < input.length()) {
                    matrix[i][j] = input.charAt(ind++);
                }
            }
        }
        return matrix;
    }

    private void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
