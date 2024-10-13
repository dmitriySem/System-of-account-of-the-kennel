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
	VALUES ('вьючные'),
		('домашние');    
	CREATE TABLE home_animals
	(
 	Id INT AUTO_INCREMENT PRIMARY KEY,
 	   Genus_name VARCHAR (20),
 	   Class_id INT,
  	  FOREIGN KEY (Class_id) REFERENCES animal_classes (Id) ON DELETE CASCADE ON UPDATE CASCADE
	);
	INSERT INTO home_animals (Genus_name, Class_id)
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
	VALUES ('Лошади', 1),
	('Ослы', 1),  
	('Верблюды', 1); 
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
     '''sql   
   - ООП и Java
   - Программа-реестр домашних животных
   - Счетчик животных
