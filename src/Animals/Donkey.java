package Animals;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Donkey extends Animals implements PackedAnimals{
    public Donkey(int id, String name, LocalDate birthday, String genderName) {
        super(id, name, birthday, genderName);
    }

    public Donkey(int id, String name, LocalDate birthday, String genderName, List<String> commands) {
        super(id, name, birthday, genderName, commands);
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
