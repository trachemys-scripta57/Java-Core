package Modul_1_3.Review_3;

public class test10 {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        }
//        System.out.print("Between try and catch ");
        catch(RuntimeException e){
            System.out.print("In the catch block ");
        }finally{
            System.out.print("In the finally block ");
        }
    }
}
/* нарушен синтаксис- sout перед catch. Ошибка компиляции*/