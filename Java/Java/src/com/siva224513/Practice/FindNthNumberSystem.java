import java.util.ArrayList;
import java.util.Scanner;

public class FindNthNumberSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the number");
        int n = scanner.nextInt();
        FindNthNumberSystem f = new FindNthNumberSystem();
        f.findNthNumberSystem(n);

    }

    private void findNthNumberSystem(int n) {
        int num1 = 3, num2 = 4, n1 = 0, n2 = 0, temp1 = 0, temp2 = 0, index = 0;
        ArrayList<Integer> list = new ArrayList<>();
        n1 = (temp1 * 10) + num1;
        list.add(n1);
        n2 = (temp2 * 10) + num2;
        list.add(n2);
        while (true) {
            for (int i = 1; i <= 2; i++) {
                if (i == 1) {
                    temp1 = list.get(index++);
                    n1 = (temp1 * 10) + num1;
                    list.add(n1);
                    n2 = (temp1 * 10) + num2;
                    list.add(n2);
                } else {
                    temp2 = list.get(index++);
                    n1 = (temp2 * 10) + num1;
                    list.add(n1);
                    n2 = (temp2 * 10) + num2;
                    list.add(n2);
                }
            }
            if (list.size() > n) {
                break;
            }
        }
        System.out.println(list);
        System.out.println(list.get(n - 1));

    }
}
