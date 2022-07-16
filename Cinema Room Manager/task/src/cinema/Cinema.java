package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        final int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        final int seats = scanner.nextInt();
        String[][] reservation = new String[rows][seats];
        int action = 0;

        for (String[] row : reservation) {
            Arrays.fill(row, "S");
        }

        printCinemaReservation(reservation);

        do {
            System.out.print(
                    "1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit\n"
            );
            action = scanner.nextInt();

            switch (action) {
                case 1:
                    printCinemaReservation(reservation);
                    break;
                case 2:
                    reservation = buyTicket(scanner, rows, seats, reservation);
                    break;
                case 3:
                    printStatistics(reservation);
                case 0:
                    break;
                default:
                    break;
            }

        } while (action != 0);
    }

    private static void printStatistics(String[][] reservation) {
        int numTickets = 0;
        int currentIncome = 0;
        int maxRow = reservation.length;
        int maxColumn = reservation[0].length;
        int totalIncome;
        float percentage;

        for (int i = 0; i < reservation.length; i++) {
            for (int j = 0; j < reservation[0].length; j++) {
                if (reservation[i][j] == "B") {
                    numTickets += 1;
                    if (maxRow * maxColumn <= 60) {
                        currentIncome += 10;
                    } else if (i < maxRow / 2) {
                        currentIncome += 10;
                    } else {
                        currentIncome += 8;
                    }
                }
            }
        }

        if (maxRow * maxColumn <= 60) {
            totalIncome = maxRow * maxColumn * 10;
        } else {
            int upperRows = maxRow / 2;
            int lowerRows = maxRow - upperRows;
            totalIncome = (upperRows * 10 + lowerRows * 8)  * maxColumn;
        }

        percentage = (float) numTickets / (maxRow * maxColumn) * 100;

        System.out.printf(
                "Number of purchased tickets: %d\n" +
                "Percentage: %.2f%%\n" +
                "Current income: $%d\n" +
                "Total income: $%d\n", numTickets, percentage, currentIncome, totalIncome);
    }

    private static String[][] buyTicket(Scanner scanner, int rows, int seats, String[][] reservation) {
        int pickRow, pickColumn;

        while (true) {
            System.out.println("Enter a row number:");
            pickRow = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            pickColumn = scanner.nextInt();

            if (pickRow < 1 || pickColumn < 1 || pickRow > rows || pickColumn > seats) {
                System.out.println("Wrong input!");
                continue;
            }

            if (reservation[pickRow-1][pickColumn-1] == "B") {
                System.out.println("That ticket has already been purchased!");
            } else {
                reservation[pickRow-1][pickColumn-1] = "B";
                break;
            }
        }

        if (rows * seats <= 60) {
            System.out.print("\nTicket price: $10\n");
        } else if (pickRow <= rows / 2) {
            System.out.print("\nTicket price: $10\n");
        } else {
            System.out.print("\nTicket price: $8\n");
        }

        printCinemaReservation(reservation);
        return reservation;
    }

    private static void printCinemaReservation(String[][] reservation) {
        int rows = reservation.length;
        int seats = reservation[0].length;

        System.out.print("\nCinema:\n ");
        for (int i = 1; i < seats + 1; i++) {
            System.out.print(" " + i);
        }
        System.out.print("\n");

        for (int i = 1; i < rows + 1; i++) {
            System.out.print(i);
            for (int j = 1; j < seats + 1; j++) {
                System.out.print(" ");
                System.out.print(reservation[i - 1][j - 1]);
            }
            System.out.print("\n");
        }
    }

}