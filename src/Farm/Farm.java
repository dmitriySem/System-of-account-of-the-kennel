package Farm;


import Animals.Animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class Farm {
    private List<Animals> animalsList;


    public Farm() {
        this.animalsList = new ArrayList<>();
    }

    public void addAnimals(Animals animal){
        if (!animalsList.contains(animal))
            animalsList.add(animal);
         else
            System.out.println("Животное " + animal.getGenderName().toLowerCase(Locale.ROOT) + " '" + animal.getName() + "' " + animal.getBirthday() + " г.р. уже существует");

    }

    public int getAnimalsCount() {
        return animalsList.size();
    }

    public List<Animals> getAnimals(){
        return animalsList;
    }

    public Optional<Animals> getAnimal(Animals animal) {
        Optional<Animals> tempAnimal = Optional.empty();
        for (Animals pet: animalsList)
            if (pet.equals(animal))
                return tempAnimal.of(pet);
        return tempAnimal;
    }

    public void printTypeAnimal(Class<?> choiseClass){
        for (Animals animal:animalsList){
            if (choiseClass.isInstance(animal))
                System.out.println(animal.toString());
        }
    }

    public void printAllAnimals(){
        for (Animals animals:animalsList)
            System.out.println(animals);
    }

}
