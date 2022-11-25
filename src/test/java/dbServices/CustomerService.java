package dbServices;

import dao.CustomerDao;
import models.Customer;

import java.util.List;

public class CustomerService {
    private CustomerDao customerDao = new CustomerDao();

    public CustomerService() {
    }

    public Customer findUser(int id) {
        return customerDao.findById(id);
    }

    public void saveUser(Customer customer) {
        customerDao.save(customer);
    }

    public List<Customer> findAllUsers() {
        return customerDao.findAll();
    }
}
