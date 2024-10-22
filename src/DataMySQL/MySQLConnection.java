package DataMySQL;

import Animals.*;
import Farm.Farm;
import macro.Main;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MySQLConnection {
    private String url;
    private String user;
    private String password;
    private Farm farm;

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public MySQLConnection(String url, String name, String password, Farm farm) {
        this.url = url;
        this.user = name;
        this.password = password;
        this.farm = farm;
    }

    public void connectBase(){
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();
            // executing SELECT query
            rs = stmt.executeQuery("select * from animals_all");

            while (rs.next()) {
                if (rs.getString(4).equals("Кошки"))
                    farm.addAnimal(new Cat(
                            (farm.getAnimals().isEmpty())?1:farm.getAnimalsCount(),
                            rs.getString(1),
                            LocalDate.parse(rs.getString(2),Main.dateFormat),
                            "Кошка/Кот",
                            (rs.getString(3) == null)? Collections.emptyList():
                                    rs.getString(3).split(",").length == 0?Collections.emptyList():Arrays.asList(rs.getString(3).split(","))
                    ));
                else if (rs.getString(4).equals("Собаки"))
                    farm.addAnimal(new Dog(
                            (farm.getAnimals().isEmpty())?1:farm.getAnimalsCount(),
                            rs.getString(1),
                            LocalDate.parse(rs.getString(2),Main.dateFormat),
                            "Собака",
                            (rs.getString(3) == null)? Collections.emptyList():
                                    rs.getString(3).split(",").length == 0?Collections.emptyList():Arrays.asList(rs.getString(3).split(","))
                    ));
                else if (rs.getString(4).equals("Хомяки"))
                    farm.addAnimal(new Hamster(
                            (farm.getAnimals().isEmpty())?1:farm.getAnimalsCount(),
                            rs.getString(1),
                            LocalDate.parse(rs.getString(2),Main.dateFormat),
                            "Хомяк",
                            (rs.getString(3) == null)? Collections.emptyList():
                                    rs.getString(3).split(",").length == 0?Collections.emptyList():Arrays.asList(rs.getString(3).split(","))
                    ));
                else if (rs.getString(4).equals("Лошади"))
                    farm.addAnimal(new Horse(
                            (farm.getAnimals().isEmpty())?1:farm.getAnimalsCount(),
                            rs.getString(1),
                            LocalDate.parse(rs.getString(2),Main.dateFormat),
                            "Лошадь",
                            (rs.getString(3) == null)? Collections.emptyList():
                                    rs.getString(3).split(",").length == 1?Collections.emptyList():Arrays.asList(rs.getString(3).split(","))
                    ));
                else if (rs.getString(4).equals("Ослы"))
                    farm.addAnimal(new Donkey(
                            (farm.getAnimals().isEmpty())?1:farm.getAnimalsCount(),
                            rs.getString(1),
                            LocalDate.parse(rs.getString(2),Main.dateFormat),
                            "Осел",
                            (rs.getString(3) == null)? Collections.emptyList():
                                    rs.getString(3).split(",").length == 0?Collections.emptyList():Arrays.asList(rs.getString(3).split(","))
                    ));
                else if (rs.getString(4).equals("Верблюды"))
                    farm.addAnimal(new Camel(
                            (farm.getAnimals().isEmpty())?1:farm.getAnimalsCount(),
                            rs.getString(1),
                            LocalDate.parse(rs.getString(2),Main.dateFormat),
                            "Верблюд",
                            (rs.getString(3) == null)? Collections.emptyList():
                                    rs.getString(3).split(",").length == 0?Collections.emptyList():Arrays.asList(rs.getString(3).split(","))
                    ));

            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }


}
