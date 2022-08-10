package Modul_1_3.Review_3;

import java.io.FileReader;
import java.io.IOException;

public class test3 {
    public static void main(String[] args) {
        try (FileReader f = new FileReader("/a.txt")) {
            System.out.print("Try block ");
        } catch (IOException e) {
            System.out.print("Catch block ");
        }
//        System.out.print(f.read());
        /* всё что объявлено в блоке TRY не доступно в Catch и далее*/
    }
}
