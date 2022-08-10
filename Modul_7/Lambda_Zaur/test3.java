package Modul_7.Lambda_Zaur;

public class test3 {
    static void def(J i) {
        System.out.println(i.abc());
    }

    public static void main(String[] args) {
        def(() -> 18);
    }
}
interface J {
    int abc();
}
