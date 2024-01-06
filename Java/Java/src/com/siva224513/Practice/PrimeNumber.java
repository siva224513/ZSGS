

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        PrimeNumber p = new PrimeNumber();
        Scanner scan = new Scanner(System.in);
        System.out.println("enter the starting range");
        int start = scan.nextInt();
        System.out.println("enter the ending range");
        int end = scan.nextInt();
        for (int i = start; i <= end; i++) {
            if (p.isPrimeNumber(i)) {
                System.out.print(i + " ");
            }
        }

    }

    private boolean isPrimeNumber(int n) {

        if (n < 2)
            return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
