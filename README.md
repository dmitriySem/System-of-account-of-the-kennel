#  Информация о проекте
 Необходимо организовать систему учета для питомника в котором живут домашние и вьючные животные.

# Задание

1. Операционные системы и виртуализация (Linux)
   - Использование команды cat в Linux:
     
     Создать два текстовых файла: "Pets"(Домашние животные) и "Pack animals"(вьючные животные), используя команду `cat` в терминале Linux.
     В первом файле перечислить собак, кошек и хомяков. Во втором — лошадей, верблюдов и ослов.
     Объединить содержимое этих двух файлов в один и просмотреть его содержимое.
     Переименовать получившийся файл в "Human Friends". <br>     
     ![image](https://github.com/user-attachments/assets/dad2402b-44a9-4591-be20-249c84bf3f75) <br>
     ![image](https://github.com/user-attachments/assets/41b5d858-c508-42b1-8a4d-d845a8bc4c2d) <br>
     ![image](https://github.com/user-attachments/assets/435a6922-c97d-4a0d-af68-7746687097b1) <br>
   - Работа с директориями в Linux:
     Создать новую директорию и переместить туда файл "Human Friends".
     ![image](https://github.com/user-attachments/assets/461dd8ea-817b-4b85-9956-5d2beb7f3122) <br>
     ![image](https://github.com/user-attachments/assets/2c805b6a-ffdd-420b-b1b9-5810191b3ad1) <br>
     ![image](https://github.com/user-attachments/assets/fb36751b-e294-4532-b279-827a7a18ae71) <br>

   - Работа с MySQL в Linux
     Установить MySQL на вашу вычислительную машину.
     Подключить дополнительный репозиторий MySQL и установить один из пакетов из этого репозитория
    ![image](https://github.com/user-attachments/assets/d30cb7fe-0ad7-448e-844c-a6a5d9dbfbb7)<br>
    ![image](https://github.com/user-attachments/assets/daa287bd-b12e-4625-adb4-5065ed86f11a)<br>
   - Управление deb-пакетами
   - История команд в терминале Ubuntu
      <br>
      cat > Pets<br>
      cat > Pack<br>
      cat Pets Pacs > animals<br>
      cat animals<br>
      mv animals Human Friends<br>
      ls <br>
      <br><br>
      cd ..<br>
      mkdir dirformove<br>
      cd ~/dirformove<br>
      mv Human Friends ~/dirformove<br>
      cd ~/dirformove<br>
      ls<br>
      <br>
      sudo wget https://dev.mysql.com/get/mysql-apt-config_0.8.23-1_all.deb<br>
      sudo dpkg -i mysql-apt-config_0.8.23-1_all.deb<br>
      sudo apt-get update<br>
      sudo apt-get install mysql-server<br>
      <br>
      sudo wget https://download.docker.com/linux/ubuntu/dists/jammy/pool/stable/amd64/docker-ce-cli_20.10.13~3-0~ubuntu-jammy_amd64.deb<br>
      sudo dpkg -i docker-ce-cli_20.10.133-0ubuntu-jammy_amd64.deb<br>
      sudo dpkg -r docker-ce-cli<br>
2.  Объектно-ориентированное программирование
   - Нарисовать диаграмму, в которой есть класс родительский класс, домашние животные и вьючные животные, в составы которых в случае домашних
     животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные войдут: Лошади, верблюды и ослы).
     ![image](https://github.com/user-attachments/assets/a3231e3f-14f0-4c46-81ac-c6adf1f626c4)
   - В подключенном MySQL репозитории создать базу данных “Друзья человека”<br>
   ```sql
   CREATE DATABASE Human_friends;
  ```
   - Создать таблицы с иерархией из диаграммы в БД
```sql
USE Human_friends;
CREATE TABLE animal_classes
(
	Id INT AUTO_INCREMENT PRIMARY KEY,
	Class_name VARCHAR(20)
);
INSERT INTO animal_classes (Class_name)
	VALUES ('вьючные'), ('домашние');
CREATE TABLE home_animals
(
	Id INT AUTO_INCREMENT PRIMARY KEY,
	Genus_name VARCHAR (20),
	Class_id INT,
	FOREIGN KEY (Class_id) REFERENCES animal_classes (Id) ON DELETE CASCADE ON UPDATE CASCADE
	);
INSERT INTO home_animals
(
	Genus_name, Class_id)
	VALUES ('Кошки', 2),
	('Собаки', 2),  
	('Хомяки', 2);
CREATE TABLE cats
(
	Id INT AUTO_INCREMENT PRIMARY KEY, 
	Name VARCHAR(20), 
	Birthday DATE,
	Commands VARCHAR(50),
	Genus_id int,
	Foreign KEY (Genus_id) REFERENCES home_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE dogs 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES home_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE hamsters 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES home_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE packed_animals
(
	  Id INT AUTO_INCREMENT PRIMARY KEY,
    Genus_name VARCHAR (20),
    Class_id INT,
    FOREIGN KEY (Class_id) REFERENCES animal_classes (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO packed_animals (Genus_name, Class_id)
VALUES ('Лошади', 1), ('Ослы', 1), ('Верблюды', 1); 
CREATE TABLE horses 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES packed_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE donkeys 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES packed_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE camels 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES packed_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
```
- Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения
  ```sql
  INSERT INTO hamsters (Name, Birthday, Commands, Genus_id)
  VALUES ('Рыжый', '2021-10-12', ' ', 3),
  ('Пушок', '2021-03-12', 'бег в колесе', 3),
  ('Белок', '2022-07-11', NULL, 3),
  ('Бурый', '2022-05-10', NULL, 3);

  INSERT INTO dogs (Name, Birthday, Commands, Genus_id)
  VALUES ('Ричик', '2020-01-01', 'ко мне, лежать, лапу, голос', 2),
  ('Тишка', '2021-06-12', "сидеть, лежать, лапу", 2),
  ('Шарик', '2018-05-01', "сидеть, лежать, лапу, след, фас", 2),
  ('Босс', '2021-05-10', "сидеть, лежать, фу, место", 2);

  INSERT INTO cats (Name, Birthday, Commands, Genus_id)
  VALUES ('Пупа', '2011-01-01', 'кс-кс-кс', 1),
  ('Олег', '2016-01-01', "", 1),
  ('Тьма', '2017-01-01', "", 1);

  INSERT INTO horses (Name, Birthday, Commands, Genus_id)
  VALUES ('Гром', '2020-01-12', 'бегом, шагом', 1),
  ('Закат', '2017-03-12', "бегом, шагом, хоп", 1),
  ('Байкал', '2016-07-12', "бегом, шагом, хоп, брр", 1),
  ('Молния', '2020-11-10', "бегом, шагом, хоп", 1);

  INSERT INTO donkeys (Name, Birthday, Commands, Genus_id)
  VALUES ('Первый', '2019-04-10', NULL, 2),
  ('Второй', '2020-03-12', "", 2),
  ('Третий', '2021-07-12', "", 2),
  ('Четвертый', '2022-12-10', NULL, 2);

  INSERT INTO camels (Name, Birthday, Commands, Genus_id)
  VALUES ('Горбатый', '2022-04-10', 'вернись', 3),
  ('Самец', '2019-03-12', "остановись", 3),
  ('Сифон', '2015-07-12', "повернись", 3),
  ('Борода', '2022-12-10', "улыбнись", 3);
  ```
  - Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу
  ```sql
  SET SQL_SAFE_UPDATES = 0;
  DELETE FROM camels;

  SELECT Name, Birthday, Commands FROM horses
  UNION SELECT  Name, Birthday, Commands FROM donkeys;
  ```
  - Создать новую таблицу “молодые животные” в которую попадут все животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице
    ```sql
    CREATE TEMPORARY TABLE animals AS
    SELECT *, 'Лошади' FROM horses
    UNION SELECT *, 'Ослы' FROM donkeys
    UNION SELECT *, 'Собаки' FROM dogs
    UNION SELECT *, 'Кошки' FROM cats
    UNION SELECT *, 'Хомяки' FROM hamsters;

    CREATE TABLE yang_animal AS
    SELECT Name, Birthday,
    TIMESTAMPDIFF(YEAR, Birthday, CURDATE()) AS years,
    TIMESTAMPDIFF(MONTH, Birthday, CURDATE()) % 12 AS months
    FROM animals WHERE Birthday BETWEEN ADDDATE(curdate(), INTERVAL -3 YEAR) AND ADDDATE(CURDATE(), INTERVAL -1 YEAR);

    SELECT * FROM yang_animal;
    ```
    - Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.
      ```sql
      SELECT h.Name, h.Birthday, h.Commands, pa.Genus_name,
      TIMESTAMPDIFF(YEAR, h.Birthday, CURDATE()) AS years,
      TIMESTAMPDIFF(MONTH, h.Birthday, CURDATE()) % 12 AS months 
      FROM horses h
      LEFT JOIN packed_animals pa ON pa.Id = h.Genus_id
      UNION 
      SELECT d.Name, d.Birthday, d.Commands, pa.Genus_name,
      TIMESTAMPDIFF(YEAR, d.Birthday, CURDATE()) AS years,
      TIMESTAMPDIFF(MONTH, d.Birthday, CURDATE()) % 12 AS months 
      FROM donkeys d 
      LEFT JOIN packed_animals pa ON pa.Id = d.Genus_id
      UNION
      SELECT c.Name, c.Birthday, c.Commands, ha.Genus_name,
      TIMESTAMPDIFF(YEAR, c.Birthday, CURDATE()) AS years,
      TIMESTAMPDIFF(MONTH, c.Birthday, CURDATE()) % 12 AS months
      FROM cats c
      LEFT JOIN home_animals ha ON ha.Id = c.Genus_id
      UNION
      SELECT d.Name, d.Birthday, d.Commands, ha.Genus_name,
      TIMESTAMPDIFF(YEAR, d.Birthday, CURDATE()) AS years,
      TIMESTAMPDIFF(MONTH, d.Birthday, CURDATE()) % 12 AS months
      FROM dogs d
      LEFT JOIN home_animals ha ON ha.Id = d.Genus_id
      UNION
      SELECT hm.Name, hm.Birthday, hm.Commands, ha.Genus_name,
      TIMESTAMPDIFF(YEAR, hm.Birthday, CURDATE()) AS years,
      TIMESTAMPDIFF(MONTH, hm.Birthday, CURDATE()) % 12 AS months
      FROM hamsters hm
      LEFT JOIN home_animals ha ON ha.Id = hm.Genus_id;
      ```

   - ООП и Java
   - Программа-реестр домашних животных
   - Счетчик животных
