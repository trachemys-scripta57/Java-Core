/* Напишите метод int sumOfStream(InputStream inputStream), который принимает
InputStream и возвращает сумму всех его элементов.

Пример ввода: 1, 2, 4, 10

Пример вывода: 17

Требования:
1. Метод должен быть публичным.
2. Параметр должен иметь тип InputStream.
3. Сигнатура метода должна быть: sumOfStream(InputStream inputStream)
https://javarush.ru/quests/lectures/questsyntaxpro.level15.lecture01 */

package Modul_5.InputOutput;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SumOfSteam {
    public static int sumOfStream(InputStream inputStream) throws IOException {
        int total = 0;
        int x;

        while ((x = inputStream.read()) != -1) {
            total += (byte) x;
        }

        return total;
    }

    public static void main(String[] args) {
        byte[] bytes = {-100, -3, 3, 4};
        InputStream inputStream = new ByteArrayInputStream(bytes);
        try {
            System.out.println(sumOfStream(inputStream));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
