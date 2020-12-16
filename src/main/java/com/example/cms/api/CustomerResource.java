package com.example.cms.api;

import com.example.cms.model.Customer;
import com.example.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {
    //Dependency Injection
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return this.customerService.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return this.customerService.getCustomers();
    }

    @GetMapping(value = "/{id}")
    public Customer getCustomer(@PathVariable("id") int id) {
        return this.customerService.getCustomer(id);
    }

    @PutMapping(value = "/{id}")
    public Customer updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
        return this.customerService.updateCustomer(id, customer);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCustomer(@PathVariable("id") int id) {
        this.customerService.deleteCustomer(id);
    }
}
