package macro;

import Animals.Animals;
import Animals.Cat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Animals cat = new Cat(1, "Тишка", LocalDate.now(), "Кошка");
        System.out.println(cat);
    }
}
