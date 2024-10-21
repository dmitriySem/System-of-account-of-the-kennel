package Animals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Animals {
    protected int id;
    protected String Name;
    protected LocalDate Birthday;
    protected String GenderName;

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
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return format.format(Birthday);
    }

    public void setBirthday(LocalDate birthday) {
        Birthday = birthday;
    }

    public Animals(int id, String name, LocalDate birthday, String genderName) {
        this.id = id;
        Name = name;
        Birthday = birthday;
        GenderName = genderName;
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
