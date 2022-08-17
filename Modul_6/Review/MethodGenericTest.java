package Modul_6.Review;

import java.util.ArrayList;
import java.util.List;

public class MethodGenericTest {
    public static <T> void fill(List<T> list, T val) {
        for (int i = 0; i < list.size(); i++)
            list.set(i, val);
    }
/* типизированный метод fill легко работает с разными типами данных */

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        strings.add("Старая строка 1");
        strings.add("Старая строка 2");
        strings.add("Старая строка 3");

        fill(strings, "Новая строка");

        System.out.println(strings);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        fill(numbers, 888);
        System.out.println(numbers);
    }
}
