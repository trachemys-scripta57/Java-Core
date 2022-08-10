/* https://javarush.ru/groups/posts/2315-stiranie-tipov */

package Modul_6.Review;

import java.time.chrono.Era;

public class ErasureTypeTest<T> {
    private T value1;
    private T value2;

    public void printValues() {
        System.out.println(value1);
        System.out.println(value2);
    }

    public static <T> ErasureTypeTest<T> createAndAdd2Values(Object o1, Object o2) {
        ErasureTypeTest<T> result = new ErasureTypeTest<>();
        result.value1 = (T) o1;
        result.value2 = (T) o2;
        return result;
    }

    public static void main(String[] args) {
        Double d = 22.111;
        String s = "Test String";
        ErasureTypeTest<Integer> test = createAndAdd2Values(d, s);
        test.printValues();
    }
}
/* Во время компиляции кода информация о типе-параметре Integer объекта
* ErasureTypeTest<Integer> test стрёрлась и превратилась в ErasureTypeTest<Object> test  */
