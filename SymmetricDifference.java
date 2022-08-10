/* Реализуйте метод symmetricDifference, вычисляющий симметрическую
разность двух множеств. Метод должен возвращать результат в виде
нового множества. Изменять переданные в него множества не допускается.

Пример ввода: [1, 2, 3} и {0, 1, 2]
Пример вывода: [0, 3]

Требования:
1. должен быть метод public static Set symmetricDifference(Set set1, Set set2)
2. метод symmetricDifference не должен изменять исходные множества
3. метод symmetricDifference должен возвращать корректный результат


 * @see https://ru.wikipedia.org/wiki/Симметрическая_разность */

package Modul_6;

import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> symmetrDiff = new HashSet<T>(set1);
        symmetrDiff.addAll(set2);
        Set<T> z = new HashSet<T>(set1);
        z.retainAll(set2); //Сохраняет только те элементы в этом наборе, которые содержатся в указанной коллекции
        symmetrDiff.removeAll(z);

        return symmetrDiff;
    }

    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>();
        s1.add(1);
        s1.add(2);
        s1.add(3);

        HashSet<Integer> s2 = new HashSet<>();
        s2.add(0);
        s2.add(1);
        s2.add(2);

        Set<Integer> result = symmetricDifference(s1, s2);
        System.out.println(result);
    }
}
