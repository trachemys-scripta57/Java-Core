
/* Напишите метод, возвращающий стрим псевдослучайных целых чисел.
Алгоритм генерации чисел следующий:

Берется какое-то начальное неотрицательное число (оно будет
передаваться в ваш метод проверяющей системой).
Первый элемент последовательности устанавливается равным этому числу.
Следующие элементы вычисляются по рекуррентной формуле Rn+1=mid(Rn2),
где mid — это функция, выделяющая второй, третий и четвертый разряд
переданного числа. Например, mid(123456)=345.

Алгоритм, конечно, дурацкий и не выдерживающий никакой критики, но
для практики работы со стримами сойдет :)

Пример ввода: 13
Пример вывода: 13, 16, 25, 62, 384, 745, 502, 200, 0, ...
(дальше бесконечное количество нулей)

Требования:
1. Должен быть метод public static IntStream pseudoRandomStream(int seed)
2. Метод должен возвращать поток, удовлетворяющий условию
*/
package Modul_7;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class PsevdoRandomStream {
    public static IntStream pseudoRandomStream(int seed) {
        IntSupplier gen = new IntSupplier() {
            int current = 0;

            @Override
            public int getAsInt() {
                return mid(current++);
            }

            int mid(int idx) {
                if (idx == 0) return seed;
                int m = mid(idx - 1);
                m *= m;

                int result = 0, cnt = 0, r;
                while (m > 0) {
                    r = m % 10;
                    cnt++;
                    if (cnt >= 2 && cnt <= 4) result += r * Math.pow(10, cnt - 2);
                    m /= 10;
                }
                return result;
            }
        };
        return IntStream.generate(gen);
    }

    public static void main(String[] args) {
        IntStream z = pseudoRandomStream(13);
        z.limit(10).forEach(System.out::println);
    }
}
