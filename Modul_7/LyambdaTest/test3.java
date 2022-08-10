/* UnaryOperator — функциональный интерфейс, принимает в
качестве параметра объект типа T, выполняет над ним
некоторые операции и возвращает результат операций в виде
объекта того же типа T.
 UnaryOperator, который своим методом apply возводит число в квадрат */

package Modul_7.LyambdaTest;

public class test3 {
    @FunctionalInterface
    public interface UnaryOperator<T> {
        T apply(T t);
    }
    public static void main(String[] args) {
        UnaryOperator<Integer> squareValue = x -> x * x;
        System.out.println(squareValue.apply(9));
    }
}
