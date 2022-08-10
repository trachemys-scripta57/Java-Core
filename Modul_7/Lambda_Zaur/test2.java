/* Принимаем строку и возвращаем её длину плюс значение int */

package Modul_7.Lambda_Zaur;

public class test2 {
    static void def(I i) {
        System.out.println(i.abc("privet"));
    }

    public static void main(String[] args) {
        int i = 10; /* это неизменяемая переменная - effectively final -
        значение не изменяется после инициализации */
        def((String s) -> { // s видна только в теле выражения
            return s.length() + i;
        });
    }
}

interface I {
    int abc(String s);
}
