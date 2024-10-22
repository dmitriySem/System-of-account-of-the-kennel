package macro;

import Animals.Animals;
import Animals.Cat;
import Animals.Dog;
import Animals.Horse;
import Animals.Hamster;
import Animals.Camel;
import Animals.Donkey;

import DataMySQL.MySQLConnection;
import Farm.Farm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {

    private static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final String urlMysql_localhost = "jdbc:mysql://localhost:3306/human_friends?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String userName = "root";
    private static final String password = "1111";


//    private Farm farm;

    public static void main(String[] args) {
	// write your code here

//        Farm farm = new Farm();
//        farm.addAnimal(new Cat(1, "Тишка", LocalDate.now(), "Кошка"));
//        farm.addAnimal(new Cat(2, "Буська", LocalDate.of(2024,8,4), "Кошка"));
////        farm.addAnimal(new Cat(3, "Буська", LocalDate.of(2024,8,4), "Кошка"));
//        farm.addAnimal(new Horse(4, "Черныш", LocalDate.of(2020,1,5), "Лошадь"));
//        farm.addAnimal(new Dog(5, "Зара", LocalDate.of(2019, 3,4),"Собака",new ArrayList<>(Arrays.asList("Ко мне!", "Фас!", "Сидеть!"))));
//
//


        Farm farm = new Farm();
        MySQLConnection connection = new MySQLConnection(urlMysql_localhost, userName, password);
        connection.connectBase();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить новое животное");
            System.out.println("2. Список команд животного");
            System.out.println("3. Обучить животное новой команде");
            System.out.println("4. Вывести список животных по дате рождения");
            System.out.println("5. Сохранить данные");
            System.out.println("6. Вывести общее количество созданных животных");
            System.out.println("7. Выход");
            System.out.print("Выберите пункт: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    addAnimalMenu(scanner, farm);
                    break;
                case 2:
                    listCommandsMenu(scanner, farm);
                    break;
                case 3:
                    addCommandMenu(scanner,farm);
                    break;
                case 4:
                    farm.listAnimalsByBirthDay();
                    break;
//                case 5:
//                    registry.saveToFile(FILENAME);
//                    System.out.println("Данные сохранены.");
//                    break;
                case 6:
                    System.out.println("Общее количество животных: " + farm.getAnimalsCount());
                    break;
                case 7:
//                    System.out.println("Сохранить данные перед выходом? (y/n)");
//                    if (scanner.nextLine().equalsIgnoreCase("y")) {
//                        registry.saveToFile(FILENAME);
//                    }
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void addAnimalMenu(Scanner scanner, Farm farm) {
        System.out.println("Выберите тип животного: 1. Кошка 2. Собака 3. Хомяк 4. Лошадь 5. Верблюд 6. Осел");
        int type = scanner.nextInt();
        scanner.nextLine();  // consume newline

        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите дату рождения (yyyy-MM-dd): ");
        String birthDateStr = scanner.nextLine();
        LocalDate birthDate = null;
        try {
            birthDate = LocalDate.parse(birthDateStr, dateFormat);
        } catch (DateTimeParseException e) {
            System.out.println("Неверный формат даты.");
            return;
        }

        Animals animal;
        switch (type) {
            case 1:
                animal = new Cat(farm.getAnimalsCount(), name, birthDate, "Кошка");
                break;
            case 2:
                animal = new Dog(farm.getAnimalsCount(), name, birthDate, "Собака");
                break;
            case 3:
                animal = new Hamster(farm.getAnimalsCount(), name, birthDate, "Хомяк");
                break;
            case 4:
                animal = new Horse(farm.getAnimalsCount(), name, birthDate, "Лошадь");
                break;
            case 5:
                animal = new Camel(farm.getAnimalsCount(), name, birthDate, "Верблюд");
                break;
            case 6:
                animal = new Donkey(farm.getAnimalsCount(), name, birthDate, "Осел");
                break;
            default:
                System.out.println("Неверный тип животного.");
                return;
        }

        farm.addAnimal(animal);
        System.out.println("Животное добавлено.");
    }

    private static void listCommandsMenu(Scanner scanner, Farm farm) {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        Optional<Animals> animal = farm.getAnimal(name);
        if (animal.isPresent()) {
            animal.get().printCommands();
        } else {
            System.out.println("Животное не найдено.");
        }
    }

    private static void addCommandMenu(Scanner scanner, Farm farm) {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        Optional<Animals> animal = farm.getAnimal(name);
        if (animal.isPresent()) {
            System.out.print("Введите новую команду: ");
            String command = scanner.nextLine();
            animal.get().addCommand(command);
            System.out.println("Команда добавлена.");
        } else {
            System.out.println("Животное не найдено.");
        }
    }
}
