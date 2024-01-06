

import java.util.Arrays;
import java.util.Scanner;

public class KthSmallest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        KthSmallest s = new KthSmallest();
        System.out.println("Enter the size of the array");
        int n = scan.nextInt();
        System.out.println("Enter " + n + " elements");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        System.out.println("Enter the value of the k");
        int k = scan.nextInt();
        s.findKthSmallest(arr, n, k);
    }

    private void findKthSmallest(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int j = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[j]) {
                j++;
                arr[j] = arr[i];

            }
        }

        if (k > j + 1) {
            System.out.println("k is greater than array size");
        } else {
            System.out.println(k + "- smallest element is " + arr[k - 1]);
        }

    }

}
