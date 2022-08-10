package Modul_1_3.Review_3;

import java.io.FileNotFoundException;
import java.io.IOException;

public class test8 {
    public static void main(String[] args) {
        try {
            readFromFile();
//        } catch (IOException | FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("Done");
    }

    public static void readFromFile() throws IOException {
        System.out.print("Reading line ");
    }
}
/* FileNoFoundException подкласс IOException - ошибка */