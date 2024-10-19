package Animals;

import java.time.LocalDate;

public class Cat extends Animals implements HomeAnimals{
    public Cat(int id, String name, LocalDate birthday, String genderName) {
        super(id, name, birthday, genderName);
    }

    @Override
    public String toString() {
        return "Кошка{" +
                "Имя='" + Name + '\'' +
                ", День рождения= " + Birthday +
                ", Гендер=" + GenderName +
                ", Домашнее животное"  +
                '}';
    }
}
