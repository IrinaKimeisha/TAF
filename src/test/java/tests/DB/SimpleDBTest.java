package tests.DB;

import baseEntities.BaseApiTest;
import dbEntities.CustomersTable;
import dbServices.CustomerService;
import models.Customer;
import models.CustomerBuilder;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SimpleDBTest extends BaseApiTest {
    @Test
    public void simpleDBTest() {
        CustomersTable customersTable = new CustomersTable(dataBaseService);
        customersTable.dropTable();
        customersTable.createCustomersTable();

        customersTable.addCustomer(CustomerBuilder.builder()
                .firstName("Ivan")
                .lastName("Ivanov")
                .email("iv@mail.com")
                .age(32)
                .build());
        customersTable.addCustomer(CustomerBuilder.builder()
                .firstName("Petr")
                .lastName("Petrov")
                .email("pe@mail.com")
                .age(28)
                .build());

        customersTable.addCustomer(CustomerBuilder.builder()
                .firstName("Marina")
                .lastName("Petrova")
                .email("mae@mail.com")
                .age(23)
                .build());

        ResultSet rs = customersTable.getCustomers();
        try {
            while (rs.next()) {
                String userid = rs.getString("ID");
                String firstName = rs.getString("firstname");
                String lastName = rs.getString("Lastname");
                int age = rs.getInt("age");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void hibernateTest() {
        CustomerService customerService = new CustomerService();
        Customer customer = new Customer("Ivan", "Grigoriev", "sfs@mail.ru", 30);

        customerService.saveUser(customer);

        List<Customer> customerList = customerService.findAllUsers();
        for (Customer user : customerList) {
            System.out.println(user.toString());
        }

    }
}
