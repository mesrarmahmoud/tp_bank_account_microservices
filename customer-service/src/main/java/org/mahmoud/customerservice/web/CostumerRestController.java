package org.mahmoud.customerservice.web;

import org.mahmoud.customerservice.entities.Customer;
import org.mahmoud.customerservice.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CostumerRestController {
    private CustomerRepository customerRepository;

    public CostumerRestController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @GetMapping("/customers")
    public List<Customer> costumersList() {
        return customerRepository.findAll();
    }
    @GetMapping("/customers/{id}")
    public Customer costumerById(@PathVariable Long id) {
        return customerRepository.findById(id).get();
    }
}
