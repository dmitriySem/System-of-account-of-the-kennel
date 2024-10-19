package Animals;

import java.time.LocalDate;

public class Donkey extends Animals implements PackedAnimals{
    public Donkey(int id, String name, LocalDate birthday, String genderName) {
        super(id, name, birthday, genderName);
    }

    @Override
    public String toString() {
        return "Осел{" +
                "Имя='" + Name + '\'' +
                ", День рождения=" + Birthday +
                ", Гендер='" + GenderName + '\'' +
                ", Вьючное животное'"  +
                '}';
    }
}
