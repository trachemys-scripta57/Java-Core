
/* Реализуйте generic-класс Pair, похожий на Optional, но содержащий пару элементов
разных типов и не запрещающий элементам принимать значение null.

Реализуйте методы getFirst(), getSecond(), equals() и hashCode(), а также статический
фабричный метод of(). Конструктор должен быть закрытым (private).

С корректно реализованным классом Pair должен компилироваться и успешно работать
следующий код:


Pair<Integer, String> pair = Pair.of(1, "hello");
Integer i = pair.getFirst(); // 1
String s = pair.getSecond(); // "hello"
Pair<Integer, String> pair2 = Pair.of(1, "hello");
boolean mustBeTrue = pair.equals(pair2); // true!
boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!

Пожалуйста, не меняйте модификатор доступа класса Pair. Для корректной проверки
класс должен иметь пакетную видимость.
*/

package Modul_6.Pair;

import java.util.Objects;

public class Pair<X, Y> {


    private final X firstValue;
    private final Y secondValue;

    private Pair(X x, Y y) {
        firstValue = x;
        secondValue = y;
    }

    public X getFirst() {

        return firstValue;
    }

    public Y getSecond() {

        return secondValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(firstValue, pair.firstValue) && Objects.equals(secondValue, pair.secondValue);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstValue, secondValue);
    }

    public static <X, Y> Pair<X, Y> of(X x, Y y) {

        return new Pair<>(x, y);
    }
}
