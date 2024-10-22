package Animals;

import macro.Main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Animals {
    protected int id;
    protected String Name;
    protected LocalDate Birthday;
    protected String GenderName;
    protected List<String> Commands;

    private DateTimeFormatter format;

    public Animals(int id, String name, LocalDate birthday, String genderName) {
        this.id = id;
        Name = name;
        Birthday = birthday;
        GenderName = genderName;
        Commands = new ArrayList<>();
    }

    public Animals(int id, String name, LocalDate birthday, String genderName, List<String> commands) {
        this.id = id;
        Name = name;
        Birthday = birthday;
        GenderName = genderName;
        Commands = commands;
    }

    public List<String> getCommands() {
        return Commands;
    }

    public void addCommand(String command) {
        Commands.add(command);

    }

    public String getGenderName() {
        return GenderName;
    }

    public void setGenderName(String genderName) {
        GenderName = genderName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBirthday() {
//        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return Main.dateFormat.format(Birthday);
    }

    public void setBirthday(LocalDate birthday) {
        Birthday = birthday;
    }

    public void printCommands(){
        System.out.print(this.toString());
        if (getCommands().isEmpty())
            System.out.println(" - это животное не выполняет команды");
        else{
            System.out.println(" может выполнять команды: ");
            getCommands().forEach(command -> System.out.print(" " + command));
        }
    }


    @Override
    public String toString() {
        return String.format("%d. %s: имя: %s, дата рождения: %s ", getId(), getClass().getSimpleName(), getName(), getBirthday());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animals animals = (Animals) o;
        return Objects.equals(Name, animals.Name) && Objects.equals(Birthday, animals.Birthday) && Objects.equals(GenderName, animals.GenderName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Birthday, GenderName);
    }
}
