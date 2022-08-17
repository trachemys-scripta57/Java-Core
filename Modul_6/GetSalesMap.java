/* Магазину нужно сохранять информацию о продажах для каждого сотрудника.
Напишите метод Map getSalesMap(Reader reader) который принимает Reader
содержащий строки вида:

Алексей 3000
Дмитрий 9000
Антон 3000
Алексей 7000
Антон 8000

Метод должен получить все строки из Reader и заполнить и вернуть карту
где ключом будет имя сотрудника, а значением сумма всех его продаж.

Пример ввода:
Алексей 3000
Дмитрий 9000
Антон 3000
Алексей 7000
Антон 8000

Пример вывода:
{Алексей=[10000], Дмитрий=[9000], Антон=[11000]}

Требования:
1. Должен быть метод public static Map<String, Long> getSalesMap(Reader reader)
2. Работа метода getSalesMap должна удовлетворять условию */

package Modul_6;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class GetSalesMap {
    public static Map<String, Long> getSalesMap(Reader reader) throws IOException {
        Map<String, Long> result = new LinkedHashMap<>();
        Scanner scan = new Scanner(reader);

        while (scan.hasNextLine()) {

            StringBuilder strB = new StringBuilder(scan.nextLine());
            String strValue = strB.substring(0, strB.indexOf(" "));
            Long longValue = new Scanner(strB.substring(strB.indexOf(" ") + 1)).nextLong();

//            System.out.println(strValue);
//            System.out.println(longValue);

            result.merge(strValue,longValue,(a, b) -> b + result.get(strValue));
//            result.forEach((a, b) -> System.out.println(strValue + " " + longValue));

//            if (!result.containsKey(strValue)) {
//                result.put(strValue, longValue);
//            } else {
//                result.replace(strValue, result.get(strValue), result.get(strValue) + longValue);
//            }
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
