package task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int amount = scanner.nextInt();
        int[] denominationArray = {5000, 1000, 500, 100, 50, 10, 5, 2, 1};

        for (int denomination: denominationArray) {
            int numberOfDenomination = 0;
            if (amount >= denomination)
                numberOfDenomination = amount / denomination;
            System.out.println(denomination + " - " + numberOfDenomination);
            amount %= denomination;
        }
    }
}