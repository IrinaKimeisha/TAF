package dbServices;

import dao.CustomerDao;
import models.Customer;

public class CustomerService {
    private CustomerDao customerDao = new CustomerDao();

    public CustomerService() {
    }

    public Customer findUser(int id) {
        return customerDao.findById(id);
    }

    public Customer saveUser(Customer customer) {
        customerDao.save(customer);
    }
}
