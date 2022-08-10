package Modul_1_3.ArrayTest;

import java.util.Arrays;

public class ArraySum2 {
    public static void main(String[] args) {
        int[] myArray = {3, 5, -10, 7, 12};
        int b = 0;

        b = Arrays.stream(myArray).sum();

        System.out.println(b);
    }
}
