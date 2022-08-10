
/* Продолжение
https://javarush.ru/groups/posts/2315-stiranie-tipov
https://javarush.ru/groups/posts/2313-ispoljhzovanie-varargs-pri-rabote-s-dzhenerikami
https://javarush.ru/groups/posts/2324-wildcards-v-generics
* */

package Modul_6.Review;

public class ClassGenericTest<T> {
    private T t;

    public void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public static void main(String[] args) {
        ClassGenericTest<String> stringBox = new ClassGenericTest<>();

        stringBox.setT("Старая строка");
        System.out.println(stringBox.getT());

        stringBox.setT("Новая строка");
        System.out.println(stringBox.getT());

//        stringBox.setT(12345); //ошибка компиляции
    }
}
