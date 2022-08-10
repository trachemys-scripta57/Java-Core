package Modul_6.WildCards;

public class Animal {
    private int id;

    public Animal() {
    }
/* Вручную создаём пустой конструктор, т.к.в родительском
* классе Animal мы переопределили констуктор и дефолтный исчез  */

    public Animal(int id) {
        this.id = id;
    }

    public String toString() {
        return String.valueOf(id);
    }
    public void eat() {
        System.out.println("Animal is eating...");
    }
}
