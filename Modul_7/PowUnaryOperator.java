/* Напишите метод с названием sqrt, который возвращает
реализацию функционального интерфейса UnaryOperator,
который принимает целое число(тип int) и возвращает
его квадрат.

Требования:
1. Должен быть метод public UnaryOperator sqrt()
2. Метод должен возвращать реализацию интерфейса UnaryOperator.
3. Реализация должна соответствовать условию */

package Modul_7;

import java.util.function.UnaryOperator;

public class PowUnaryOperator {
    public UnaryOperator<Integer> sqrt() {
        return z -> z*z;
        }
    }

