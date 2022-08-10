package Modul_1_3.Review_3;

public class test7 {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        }
        catch(RuntimeException e){
            System.out.print("In the catch block ");
        }
        System.out.print("Between catch and finally ");
//        finally{
//            System.out.print("In the finally block ");
//        }
    }
}
