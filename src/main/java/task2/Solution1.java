package main.java.task2;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Solution1 {
    public static void main(String[] args) {

        /** creating input data */
        int randomNumber = new Random().nextInt(1000) + 1;
        int[] array = IntStream.range(1, 1001).filter(n -> n != randomNumber).toArray();

        /** to check result */
        System.out.println("Число, которое пропущено в последовательности: " + randomNumber);

        int[] sortedArray = Arrays.stream(array)
                .sorted().toArray();

        int answer = 1;
        int i = 0;

        if (sortedArray[i] != 2) {
            while (i != 998 && (sortedArray[i + 1] - sortedArray[i]) == 1)
                ++i;
            answer = sortedArray[i] + 1;
        }

        System.out.println("Ответ: " + answer);
    }
}
