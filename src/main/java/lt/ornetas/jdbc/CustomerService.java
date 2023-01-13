package lt.ornetas.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    Repository repository = new Repository();


    public List<Customer> getAllCustomers() {

        List<Customer> customers = new ArrayList<>();

        try( Connection connection = repository.getConnection()) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from customers");



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

        } catch (Exception e) {
            e.printStackTrace();
        }

        return customers;
    }
}
