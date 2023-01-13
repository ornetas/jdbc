package lt.ornetas.jdbc;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("./src/main/resources/db.properties");

            properties.load(fileInputStream);

            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");

            Connection connection = DriverManager.getConnection(
                    url,
                    username,
                    password

            );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from customers");

            List<Customer> customers = new ArrayList<>();


            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " | " + resultSet.getString("customerName"));

                Customer custumer = new Customer(
                        resultSet.getInt("customerNumber"),
                        resultSet.getString("customerName"),
                        resultSet.getString("phone"),
                        resultSet.getString("city")
                );
                customers.add(custumer);

            }
            customers.forEach(System.out::println);
//            for (Customer customer : customers){
//                System.out.println(customer);
//            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
