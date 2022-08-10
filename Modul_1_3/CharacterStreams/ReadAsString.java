/* Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку,
используя заданную кодировку.

Пример:
InputStream последовательно возвращает четыре байта: 48 49 50 51.
Метод, вызванный для такого InputStream и кодировки ASCII, должен вернуть строку: "0123".

Требования:
1. Метод должен быть публичным.
2. Сигнатура метода должна быть: readAsString(InputStream inputStream, Charset charset) */

package Modul_1_3.CharacterStreams;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ReadAsString {
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        int x;

        Reader reader = new InputStreamReader(inputStream, charset);
        StringWriter y = new StringWriter();

        while ((x = reader.read()) != -1) {

            y.append((char) x);
        }
        return y.toString();
//        String str = new String(array, StandardCharsets.UTF_8); // for UTF-8 encoding
    }

    public static void main(String[] args) {
        byte[] array = {48, 49, 50, 51};
        Charset charset = StandardCharsets.US_ASCII;
        InputStream inputStream = new ByteArrayInputStream(array);
        try {
            System.out.println(readAsString(inputStream, charset));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
