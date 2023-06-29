package main.java.task2;

import java.util.Random;
import java.util.stream.IntStream;

public class Solution2 {
    public static void main(String[] args) {

        /** creating input data */
        int randomNumber = new Random().nextInt(1000) + 1;
        IntStream arrayWithoutNumber = IntStream.range(1, 1001).filter(n -> n != randomNumber);

        /** to check result */
        System.out.println("Число, которое пропущено в последовательности: " + randomNumber);

        IntStream arrayAll = IntStream.range(1, 1001);
        int answer = arrayAll.sum() - arrayWithoutNumber.sum();

        System.out.println("Ответ: " + answer);
    }
}
