package Animals;

import java.time.LocalDate;

public class Hamsfer extends Animals implements HomeAnimals{
    public Hamsfer(int id, String name, LocalDate birthday, String genderName) {
        super(id, name, birthday, genderName);
    }

    @Override
    public String toString() {
        return "Хомяк{" +
                "Имя='" + Name + '\'' +
                ", День рождения=" + Birthday +
                ", Гендер='" + GenderName + '\'' +
                ", Домашнее животное'"  +
                '}';
    }
}
