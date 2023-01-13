package lt.ornetas.jdbc;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        CustomerService customerService = new CustomerService();
        List<Customer> customers = new ArrayList<>();

        customers = customerService.getAllCustomers();
        customers.forEach(System.out::println);

    }
}
