package Modul_1_3.ComplexNumber;


public class EqualsExample {
    public static void main(String[] args) {
        ComplexNumber obj1 = new ComplexNumber(2, 2);
        ComplexNumber obj2 = new ComplexNumber(2, 1);
        System.out.println("Объекты :\n\tobj1 = " + obj1 +
                "\n\tobj2 = " + obj2);
        System.out.println("hashCode объектов :" +
                "\n\tobj1.hashCode = " + obj1.hashCode() +
                "\n\tobj2.hashCode = " + obj2.hashCode());
        System.out.println("Сравнение объектов :" +
                "\n\tobj1.equals(obj2) = " + obj1.equals(obj2));
    }
}
