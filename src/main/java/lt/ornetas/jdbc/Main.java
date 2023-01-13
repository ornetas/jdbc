package lt.ornetas.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/classicmodels",
                    "root",
                    "root");
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
