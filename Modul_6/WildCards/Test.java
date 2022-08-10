package Modul_6.WildCards;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Animal> listOfAnimal = new ArrayList<>();
        listOfAnimal.add(new Animal(1));
        listOfAnimal.add(new Animal(2));

        List<Dog> listOfDogs = new ArrayList<>();
        listOfDogs.add(new Dog());
        listOfDogs.add(new Dog());

        test(listOfAnimal); //тип Animal
        test(listOfDogs); // тип Dog
        /* что бы метод test принимал на вход не только тип Animal
        * но и тип Dog, меняем запись параметра метода на <? extends Animal>
         теперь метод может принимать все типы наследников класса Animal */
    }
    private static void test(List<? extends Animal> list) { //WildCard
        /*  */
        for(Animal animal : list) {
//            System.out.println(animal);
            animal.eat(); /* метод отработает 4 раза, т.е.на всех элементах
             массивов обоих листов*/
        }
    }
}
