
/* Реализуйте метод factorial, вычисляющий факториал заданного натурального числа.
   Факториал N вычисляется как 1 ⋅ 2 ⋅ ... ⋅ N
   Требования:
1. Метод должен быть public.
1. Метод должен быть static.
3. Передаваемый параметр должен иметь тип int.
4. Метод должен быть реализован через цикл.
*/

import java.math.BigInteger;

public class Factorial {
    public static BigInteger factorial(int value) {
//        BigInteger a = BigInteger.valueOf(value);
//        BigInteger c = BigInteger.ONE;
        BigInteger d = BigInteger.ONE;
        for (int i = 1; i <= value; ++i) d = d.multiply(BigInteger.valueOf(i));
        return d;

//        do {
//            c = c.multiply(d = d.add(BigInteger.ONE));
//            if (a.compareTo(new BigInteger("2")) < 0) {
//                c = BigInteger.ONE;
//                break;
//            }
//        } while (d.compareTo(a) < 0);
//        return c;
    }

    public static void main(String[] args) {

        System.out.println(factorial(3));
    }
}