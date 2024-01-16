public class PrintMatirxSingleLoop {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };

        int n = arr.length, m = arr[0].length;
        for (int i = 0; i < n * m; i++) {
            int row = i / m;
            int col = i % m;
            System.out.print(arr[row][col] + " ");
            if ((i + 1) % m == 0) {
                System.out.println();
            }
        }
    }
}
