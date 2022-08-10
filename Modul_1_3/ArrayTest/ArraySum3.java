package Modul_1_3.ArrayTest;

public class ArraySum3 {
    public static void main(String[] args) {
        int[] myArray = {3, 5, -10, 7, 12};
        int b = 0;

        for (int x : myArray) b += x; // b = b + x

        System.out.println(b);
    }
}