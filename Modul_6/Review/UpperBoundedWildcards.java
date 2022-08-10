
/* https://javarush.ru/groups/posts/2324-wildcards-v-generics */

package Modul_6.Review;

//import Cat_Dog;
import Modul_6.WildCards.Animal;
import Modul_6.WildCards.Dog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UpperBoundedWildcards {
    public static void iterateAnimals(Collection<? extends Animal> animals) {

        for(Animal animal: animals) {

            System.out.println("Еще один шаг в цикле пройден!");
        }
    }
    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal());
        animals.add(new Animal());

//        List<Pet> pets = new ArrayList<>();
//        pets.add(new Pet());
//        pets.add(new Pet());
//
//        ArrayList<Cat_Dog.Cat> cats = new ArrayList<>();
//        cats.add(new Cat_Dog.Cat());
//        cats.add(new Cat_Dog.Cat());

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());

        iterateAnimals(animals);
//        iterateAnimals(pets);
//        iterateAnimals(cats);
        iterateAnimals(dogs);
    }
}
