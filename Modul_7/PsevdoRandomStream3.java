package Modul_7;

import java.util.stream.IntStream;

public class PsevdoRandomStream3 {
    public static IntStream psevdoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> ((n * n) / 10) % 1000);
    }
    public static void main(String[] args) {
        IntStream z = psevdoRandomStream(13);
        z.limit(10).forEach(System.out::println);
    }
}
