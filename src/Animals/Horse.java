package Animals;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Horse extends Animals implements PackedAnimals{
    public Horse(int id, String name, LocalDate birthday, String genderName) {
        super(id, name, birthday, genderName);
    }

    public Horse(int id, String name, LocalDate birthday, String genderName, List<String> commands) {
        super(id, name, birthday, genderName, commands);
    }

    @Override
    public String toString() {
        return "Лошадь{" +
                "Имя='" + Name + '\'' +
                ", День рождения=" + Birthday +
                ", Вьючное животное'"  +
                '}';
    }
}
