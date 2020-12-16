package com.example.cms.service;

import com.example.cms.dao.CustomerDao;
import com.example.cms.exception.CustomerNotFoundException;
import com.example.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;
//    private int customerIdCount = 1;
//    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    public Customer addCustomer(Customer customer) {
//        customer.setId(this.customerIdCount);
//        this.customerList.add(customer);
//        this.customerIdCount++;
        return this.customerDao.save(customer);
//        return customer;
    }

    public List<Customer> getCustomers() {
        return this.customerDao.findAll();
    }

    public Customer getCustomer(int id) {
//        return this.customerList.stream()
//                .filter(customer -> customer.getId() == id)
//                .findFirst()
//                .get();
        Optional<Customer> optionalCustomer = this.customerDao.findById(id);

        if(optionalCustomer.isEmpty())
            throw new CustomerNotFoundException("Customer record is not available.");

        return optionalCustomer.get();
    }

    public Customer updateCustomer(int id, Customer customer) {
//        this.customerList
//                .forEach(c -> {
//                    if(c.getId() == id) {
//                        c.setFirstName(customer.getFirstName());
//                        c.setLastName(customer.getLastName());
//                        c.setEmail(customer.getEmail());
//                    }
//                });
        customer.setId(id);

        return this.customerDao.save(customer);
    }

    public void deleteCustomer(int id) {
//        this.customerList
//                .forEach(c -> {
//                    if(c.getId() == id) {
//                        this.customerList.remove(c);
//                    }
//                });
        this.customerDao.deleteById(id);
    }
}
