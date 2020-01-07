package com.customers.crud.controller;

import com.customers.crud.model.Customer;
import com.customers.crud.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping("/customers")
    public Customer createCustomer(@Valid @RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping("/customers/{id}")
    public Optional<Customer> getCustomerById(@PathVariable(value = "id") Long customerId) throws ChangeSetPersister.NotFoundException {
        return customerRepository.findById(customerId);
    }

    @GetMapping("/customers/{id}")
    public Customer getNoteById(@PathVariable(value = "id") Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException(Long.toString(customerId)));
    }

    @PutMapping("/customers/{id}")
    public Customer updateNote(@PathVariable(value = "id") Long customerId,
                           @Valid @RequestBody Customer customerDetails) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException(Long.toString(customerId)));

        customer.setName(customerDetails.getName());
        customer.setAddress(customerDetails.getAddress());
        customer.setPhone(customerDetails.getPhone());

        Customer updatedCustomer = customerRepository.save(customer);
        return updatedCustomer;
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException(Long.toString(customerId)));

        customerRepository.delete(customer);

        return ResponseEntity.ok().build();
    }


}
