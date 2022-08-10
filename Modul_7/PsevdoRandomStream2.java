package Modul_7;

import java.util.stream.IntStream;

public class PsevdoRandomStream2 {
    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> {
                    n = n * n;
                    int i = 0, result = 0, ten = 1;
                    while (n > 0) {
                        if (i >= 1) {
                            if (i < 4) {
                                result += (n % 10) * ten;
                                ten *= 10;

                            }
                        }
                        n /= 10;
                        i++;
                    }
                    return result;
                }
        );
    }

    public static void main(String[] args) {
        IntStream z = pseudoRandomStream(13);
        z.limit(10).forEach(System.out::println);
    }
}
//    public static IntStream pseudoRandomStream(int seed) {
//        return IntStream.iterate(  seed, n -> ( (n * n) / 10 ) % 1000  );
//    }