package Animals;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Dog extends Animals implements HomeAnimals{
    public Dog(int id, String name, LocalDate birthday, String genderName) {
        super(id, name, birthday, genderName);
    }

    public Dog(int id, String name, LocalDate birthday, String genderName, List<String> commands) {
        super(id, name, birthday, genderName, commands);
    }

    public String toString() {
        return "Собака{" +
                "Имя='" + Name + '\'' +
                ", День рождения=" + Birthday +
                ", Домашнее животное'"  +
                '}';
    }
}
