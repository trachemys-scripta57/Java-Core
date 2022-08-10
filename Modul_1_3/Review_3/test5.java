package Modul_1_3.Review_3;

public class test5 {
    public void printName() throws Exception {
        System.out.println("Toy");
    }
}

class Doll extends test5 {
    public void printName() { //необработана ошибка
        System.out.println("Doll");
    }
}

//public class TestToys {
//    public static void main(String[] args) {
//        test5 doll = new Doll();
//        doll.printName();
//    }
//}
