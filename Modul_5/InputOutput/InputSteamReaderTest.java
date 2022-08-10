/* Чтение посимвольно из файла *.txt */

package Modul_5.InputOutput;

import java.io.*;

public class InputSteamReaderTest {
    public static void main(String[] args) {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        int b = 0;

        try {
            fis = new FileInputStream("C:\\Users\\Павел\\IdeaProjects\\Test_Kata_Academy\\Kata Education Platform\\Java Core\\FIS_test.txt");
            isr = new InputStreamReader(fis, "UTF-8");
            while ((b = isr.read()) != -1) {
                System.out.print((char) b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

