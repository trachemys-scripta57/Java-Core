/* 1. Создаём новый файл MF_test.txt
   2. Пишем туда строку " Создали новый файл!" */

package Modul_5.InputOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class MakeFileTest {
    public static void main(String[] args) {

        FileWriter fr = null;
        String str = " Создали новый файл!";
        File file = new File("C:\\Users\\Павел\\IdeaProjects\\Test_Kata_Academy\\Kata Education Platform\\Java Core\\MF_test.txt");

        try {
            fr = new FileWriter(file, true);
            fr.write(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
