package macro;

import Animals.Animals;
import Animals.Cat;
import Animals.Horse;
import Animals.PackedAnimals;
import Animals.HomeAnimals;

import Farm.Farm;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Farm farm1 = new Farm();
        farm1.addAnimals(new Cat(1, "Тишка", LocalDate.now(), "Кошка"));
        farm1.addAnimals(new Cat(2, "Буська", LocalDate.of(2024,8,4), "Кошка"));
//        farm1.addAnimals(new Cat(3, "Буська", LocalDate.of(2024,8,4), "Кошка"));
        farm1.addAnimals(new Horse(4, "Черныш", LocalDate.of(2020,1,5), "Лошадь"));

//        farm1.printAllAnimals();

//        farm1.printTypeAnimal(PackedAnimals.class);
//        farm1.printTypeAnimal(HomeAnimals.class);
        System.out.println(farm1.getAnimal(new Cat(1, "Тишка", LocalDate.now(), "Кошка")).get()); ;

        System.out.println(farm1.getAnimalsCount());
    }
}
