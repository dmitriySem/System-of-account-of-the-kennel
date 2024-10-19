package Animals;

import java.time.LocalDate;

public class Horse extends Animals implements PackedAnimals{
    public Horse(int id, String name, LocalDate birthday, String genderName) {
        super(id, name, birthday, genderName);
    }

    @Override
    public String toString() {
        return "Лошадь{" +
                "Имя='" + Name + '\'' +
                ", День рождения=" + Birthday +
                ", Гендер='" + GenderName + '\'' +
                ", Вьючное животное'"  +
                '}';
    }
}
