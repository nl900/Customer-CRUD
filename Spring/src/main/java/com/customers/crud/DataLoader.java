package com.customers.crud;

import com.customers.crud.model.Customer;
import com.customers.crud.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final CustomerRepository customerRepository;

    public DataLoader(CustomerRepository customerRepository) {
        this. customerRepository = customerRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.customerRepository.save(new Customer("Steve Jones", "12 Apple St, New York 4574", "+754568675"));
    }
}
