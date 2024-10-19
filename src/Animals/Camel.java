package Animals;

import java.time.LocalDate;

public class Camel extends Animals implements PackedAnimals{

    public Camel(int id, String name, LocalDate birthday, String genderName) {
        super(id, name, birthday, genderName);
    }

    @Override
    public String toString() {
        return "Верблюд{" +
                "Имя='" + Name + '\'' +
                ", День рождения=" + Birthday +
                ", Гендер='" + GenderName + '\'' +
                ", Вьючное животное'"  +
                '}';
    }
}
