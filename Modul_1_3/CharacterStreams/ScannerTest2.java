package Modul_1_3.CharacterStreams;

import java.util.Scanner;

public class ScannerTest2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
        scanner.close();
    }
}
