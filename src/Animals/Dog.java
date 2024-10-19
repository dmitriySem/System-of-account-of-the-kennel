package Animals;

import java.time.LocalDate;

public class Dog extends Animals implements HomeAnimals{
    public Dog(int id, String name, LocalDate birthday, String genderName) {
        super(id, name, birthday, genderName);
    }

    public String toString() {
        return "Собака{" +
                "Имя='" + Name + '\'' +
                ", День рождения=" + Birthday +
                ", Гендер='" + GenderName + '\'' +
                ", Домашнее животное'"  +
                '}';
    }
}
