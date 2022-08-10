package Modul_1_3.Review_3;

public class test4 {
    public static void main(String[] args) {
        method1();
    }

    public static void method1() {
        try {
            System.out.print("Try ");
            throw new Exception();
        } catch (Exception e) {
            System.out.print("Catch ");
            return;
        } finally {
            System.out.print("Finally ");
        }
    }
}
