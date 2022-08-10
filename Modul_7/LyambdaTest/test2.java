/* https://javarush.ru/groups/posts/2866-funkcionaljhnihe-interfeysih-v-java */

package Modul_7.LyambdaTest;
/* Predicate — функциональный интерфейс для проверки соблюдения
некоторого условия. Если условие соблюдается, возвращает true,
иначе — false
 Проверяем числа на чётность....*/

public class test2 {
    @FunctionalInterface
    public interface Predicate<T> {
        boolean test(T z);
    }

    public static void main(String[] args) {
        Predicate<Integer> isEvenNumber = x -> x % 2 == 0;

        System.out.println(isEvenNumber.test(4));
        System.out.println(isEvenNumber.test(3));
    }
}
