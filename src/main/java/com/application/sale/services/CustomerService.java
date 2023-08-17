package com.application.sale.services;

import com.application.sale.models.Customer;
import com.application.sale.repositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(Long id_customer) {
        Customer customer = customerRepository.findById(id_customer).orElse(null);
        return customer;
    }

    @Override
    public void deleteCustomer(Long id_customer) {
        customerRepository.deleteById(id_customer);
    }

    @Override
    public void editCustomer(Long id_original, String newName, String newLastname, String newEmail, String newDni) {
        Customer customer = this.findById(id_original);
        customer.setName(newName);
        customer.setLastname(newLastname);
        customer.setEmail(newEmail);
        customer.setDni(newDni);
        this.saveCustomer(customer);
    }
}
