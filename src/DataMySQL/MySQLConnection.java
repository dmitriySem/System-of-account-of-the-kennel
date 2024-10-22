package DataMySQL;

import java.sql.*;

public class MySQLConnection {
    private String url;
    private String user;
    private String password;

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public MySQLConnection(String url, String name, String password) {
        this.url = url;
        this.user = name;
        this.password = password;
    }

    public void connectBase(){
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();
            // executing SELECT query
            rs = stmt.executeQuery("select count(*) from animals_all");

            while (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("Total number of animals in the table : " + count);
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
