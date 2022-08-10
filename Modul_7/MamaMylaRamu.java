
/* Напишите программу, читающую из System.in текст в кодировке UTF-8,
подсчитывающую в нем частоту появления слов, и в конце выводящую 10
наиболее часто встречающихся слов.

Словом будем считать любую непрерывную последовательность символов,
состоящую только из букв и цифр. Например, в строке "Мама мыла раму
33 раза!" ровно пять слов: "Мама", "мыла", "раму", "33" и "раза".

Подсчет слов должен выполняться без учета регистра, т.е. "МАМА",
"мама" и "Мама" — это одно и то же слово. Выводите слова в нижнем
регистре.

Если в тексте меньше 10 уникальных слов, то выводите сколько есть.

Если в тексте некоторые слова имеют одинаковую частоту, т.е. их
нельзя однозначно упорядочить только по частоте, то дополнительно
упорядочите слова с одинаковой частотой в лексикографическом порядке.

Задача имеет красивое решение через стримы без циклов и условных
операторов. Попробуйте придумать его.

Пример ввода  1:
Мама мыла-мыла-мыла раму!

Пример вывода  1:
мыла
мама
раму

Пример ввода 2:
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales
consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non,
faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur.
Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget
vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur
adipiscing elit. Integer vel odio nec mi tempor dignissim.

Пример вывода 2:
consectetur
faucibus
ipsum
lorem
adipiscing
amet
dolor
eget
elit
mi

Требования:
1. Должен быть метод public static void main(String[] args)
2. Программа должна читать данные с консоли
3. Программа должна писать данные в консоль
*/

package Modul_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.stream.Stream;

public class MamaMylaRamu {
    public static void main(String[] args) {
        HashMap<String, Integer> result = new HashMap<>();
        (new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8)))
                .lines()
                .flatMap(i -> Stream.of(i.split("[\\p{Punct}\\s]+")))
                .map(w -> w.toLowerCase()) //String::toLowerCase
                .forEach(w -> {
                    if (result.containsKey(w)) {
                        result.put(w, result.get(w) + 1);
                    } else {
                        result.put(w, 1);
                    }
                });
        result.entrySet()
                .stream()
                .sorted((z1, z2) -> {
                    if (z1.getValue() == z2.getValue()) {
                        return z1.getKey().compareTo(z2.getKey());
                    } else {
                        return z2.getValue().compareTo(z1.getValue());
                    }
                })
                .limit(10)
                .forEach(z -> System.out.println(z.getKey()));
    }
}

