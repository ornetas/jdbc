package lt.ornetas.jdbc;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/classicmodels",
                    "root",
                    "root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from customers");

            while (resultSet.next()){
            System.out.println(resultSet.getInt(1) + " | " + resultSet.getString("customerName"));
            }
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
