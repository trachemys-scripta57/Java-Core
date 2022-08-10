/* Дописываем в файл *.txt строку String */

package Modul_5.InputOutput;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
    public static void main(String[] args) {
        FileWriter fr = null;
        String str = " Java Core";

        try {
            fr = new FileWriter("C:\\Users\\Павел\\IdeaProjects\\Test_Kata_Academy\\Kata Education Platform\\Java Core\\FIS_test.txt", true);
            // параметр true - дописываем файл; false - стираем содиржимое и пишем заново
            fr.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
