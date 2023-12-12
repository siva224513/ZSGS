import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Question1 obj = new Question1();
        System.out.println("Enter the size of the array");
        int size = scan.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter the array elements");
        for (int i = 0; i < size; i++) {
            arr[i] = scan.nextInt();
        }
        obj.findMaxSubArray(arr);

    }

    private void findMaxSubArray(int[] arr) {
        int max = arr[0];
        int sum = 0;
        int start = 0;
        int end = 0;
        int curr = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > max) {
                start = curr;
                end = i;
                max = sum;
            }
            if (sum < 0) {
                curr = i +1;
                sum = 0;
            }
        }

        int a[] = new int[end - start + 1];
        System.out.println(a.length);
        int ind = 0;
        while (start <= end) {
            a[ind] = arr[start];
            ind++;
            start++;
        }

        for (int i : a) {
            System.out.print(i + " ");
        }

    }
}
