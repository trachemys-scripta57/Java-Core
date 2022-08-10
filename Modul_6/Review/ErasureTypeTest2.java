package Modul_6.Review;

import java.util.ArrayList;
import java.util.List;

public class ErasureTypeTest2 {
    private class Cat {

    }

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();

        System.out.println(strings.getClass() == numbers.getClass());
        System.out.println(numbers.getClass() == cats.getClass());

    }
}
/* Казалось бы, мы создали коллекции с тремя разными типами-параметрами —
String, Integer, и созданный нами класс Cat.
Но во время преобразования в байт-код все три списка превратились в
List<Object>, поэтому при выполнении программа говорит нам, что во всех
трех случаях у нас используется один и тот же класс. */