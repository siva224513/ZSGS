import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FindLargestChain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the row value");
        int row = scanner.nextInt();
        int col = 2;
        int arr[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        FindLargestChain f = new FindLargestChain();
        f.findLargestChain(arr);

    }

    private void findLargestChain(int[][] arr) {

        Arrays.sort(arr, new Comparator<>() {
            public int compare(int a[], int b[]) {
                return Integer.compare(a[1], b[1]);
            }
        });
       
        int curr = Integer.MIN_VALUE;
        int length = 0;
        ArrayList<int[]> list = new ArrayList<>();
       
        for (int a[] : arr) {
            
            if (curr < a[0]) {
                length++;
                curr = a[1];
                list.add(new int[]{a[0],a[1]});

            }
            
        }
        System.out.println("length is " + length);
        System.out.println("The chain is "  );
        for(int a[]:list){
            System.out.print("["+a[0]+","+a[1]+"]");
        }

    }

}