/* https://javarush.ru/groups/posts/2866-funkcionaljhnihe-interfeysih-v-java */

package Modul_7.LyambdaTest;

public class test1 {
    @FunctionalInterface
    public interface Converter<T, N> {

        N convert(T t);

        static <T> boolean isNotNull(T t){
            return t != null;
        }
    }

    public static void main(String[] args) {

    }
}
