package Modul_6;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class GetSalesMap3 {
    public static Map<String, Long> getSalesMap(Reader reader) throws IOException {
        Map<String, Long> result = new LinkedHashMap<>();
        Scanner scan = new Scanner(reader);
        while (scan.hasNext()) {
            result.merge(scan.next(), scan.nextLong(), Long::sum);
        }

        reader.close();
        return result;
    }

    public static void main(String[] args) {
        FileWriter fw = null;
        File file = new File("C:\\Users\\Павел\\IdeaProjects\\Test_Kata_Academy\\Kata Education Platform\\Java Core\\MapSalesTest.txt");

        try {
            fw = new FileWriter(file, true);
            fw.write("Алексей 3000\nДмитрий 9000\nАнтон 3000\nАлексей 7000\nАнтон 8000");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            Reader reader = new FileReader("C:\\Users\\Павел\\IdeaProjects\\Test_Kata_Academy\\Kata Education Platform\\Java Core\\MF_test.txt");
            System.out.println(getSalesMap(reader));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
