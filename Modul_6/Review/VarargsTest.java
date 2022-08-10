package Modul_6.Review;

public class VarargsTest {
    public static int sum(int...numbers) {
/* когда неизвестно сколько аргументов будет передано методу */
        int result = 0;

        for(int i : numbers) {

            result += i;
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(sum(1,2,3,4,5));
        System.out.println(sum(2,9));
    }
}
