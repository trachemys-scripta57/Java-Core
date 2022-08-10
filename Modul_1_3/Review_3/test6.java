package Modul_1_3.Review_3;

import java.io.IOException;

public class test6 {
    public static void main(String[] args) {
        try {
            throw new IOException();
        } catch (Exception e) {
            System.out.println("In the Exception catch block");
//        } catch (IOException e) {
//            System.out.println("In the IOException catch block");
//        }
        }
    }
}
/* IOException уже было поймано (объявлено) в блоке TRY */
