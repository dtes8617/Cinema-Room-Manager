import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[][] star = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i == (n - j - 1)) {
                    star[i][j] = "*";
                    System.out.print("*");
                } else if (i == n / 2 || j == n / 2) {
                    star[i][j] = "*";
                    System.out.print("*");
                } else {
                    star[i][j] = ".";
                    System.out.print(".");
                }
                if (j == n - 1) {
                    System.out.print("\n");
                } else {
                    System.out.print(" ");
                }
            }

        }
    }
}