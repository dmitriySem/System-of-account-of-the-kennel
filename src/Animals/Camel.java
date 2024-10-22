package Animals;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Camel extends Animals implements PackedAnimals{

    public Camel(int id, String name, LocalDate birthday, String genderName) {
        super(id, name, birthday, genderName);
    }

    public Camel(int id, String name, LocalDate birthday, String genderName, List<String> commands) {
        super(id, name, birthday, genderName, commands);
    }

    @Override
    public String toString() {
        return "Верблюд{" +
                "Имя='" + Name + '\'' +
                ", День рождения=" + Birthday +
                ", Вьючное животное'"  +
                '}';
    }

}
