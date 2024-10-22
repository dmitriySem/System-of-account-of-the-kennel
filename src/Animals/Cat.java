package Animals;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Cat extends Animals implements HomeAnimals{
    public Cat(int id, String name, LocalDate birthday, String genderName) {
        super(id, name, birthday, genderName);
    }

    public Cat(int id, String name, LocalDate birthday, String genderName, List<String> commands) {
        super(id, name, birthday, genderName, commands);
    }

    @Override
    public String toString() {
        return "Кошка{" +
                "Имя='" + Name + '\'' +
                ", День рождения= " + Birthday +
                ", Домашнее животное"  +
                '}';
    }



}
