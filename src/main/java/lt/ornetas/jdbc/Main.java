package lt.ornetas.jdbc;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Repository repository = new Repository();

        try( Connection connection = repository.getConnection()) {

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

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
