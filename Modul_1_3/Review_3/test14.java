package Modul_1_3.Review_3;

public class test14 {
    public static void main(String[] args) {
        try {
            System.out.print("Try ");
            throw new Exception();
        } catch (Exception e) {
            System.out.print("Catch ");
            System.exit(1);
        } finally {
            System.out.print("Finally ");
        }
        System.out.println("Done ");
    }
}
