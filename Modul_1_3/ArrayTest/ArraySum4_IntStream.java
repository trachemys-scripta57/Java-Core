package Modul_1_3.ArrayTest;

import java.util.stream.IntStream;

public class ArraySum4_IntStream {
    public static void main(String[] args) {
        int[] myArray = {3, 5, -10, 7, 12};
        int total = IntStream.of(myArray).sum();

        System.out.println(total);
    }
}
