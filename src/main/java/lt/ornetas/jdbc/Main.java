package lt.ornetas.jdbc;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/classicmodels",
                    "root",
                    "root");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from customers");

            while (rs.next()){
            System.out.println(rs.getInt(1) + " | " + rs.getString("customerName"));}
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
