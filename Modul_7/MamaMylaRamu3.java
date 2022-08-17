package Modul_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class MamaMylaRamu3 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, java.nio.charset.StandardCharsets.UTF_8));
        Arrays.stream(reader.lines() //создаём поток
                        .map(String::toLowerCase)// все символы делаем прописными
                        .reduce("", (s, l) -> s + " " + l) //сохраняем и выполняем след.операцию
                        .trim() // обрезаем пробелы с начала и с конца
                        .replaceAll("[^a-zа-я0-9\\s]", " ") //заменяем не буквенный и не цифровой символ пробелом
                        .split("\\s+"))//разбиваем строку по совподению (один или несколько пробелов)
                .collect(TreeMap<String, Integer>::new, (m, w) -> m.put(w, m.containsKey(w) ? m.get(w) + 1 : 1), TreeMap::putAll)
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .forEach(m -> System.out.println(m.getKey()));
    }
}
