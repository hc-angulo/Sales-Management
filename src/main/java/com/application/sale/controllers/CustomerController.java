package com.application.sale.controllers;

import com.application.sale.models.Customer;
import com.application.sale.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @GetMapping("")
    public List<Customer> findAll(){
        return customerService.findAll();
    }

    @PostMapping("/create")
    public String saveCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return "Customer created successfully!";
    }

    @GetMapping("/{id_customer}")
    public Customer findCustomerById(@PathVariable Long id_customer){
        return customerService.findById(id_customer);
    }

    @DeleteMapping("/delete/{id_customer}")
    public String deleteCustomer(@PathVariable Long id_customer) {
        customerService.deleteCustomer(id_customer);
        return "Customer deleted successfully";
    }

    @PutMapping("/edit/{id_customer}")
    public String editCustomer(@PathVariable Long id_customer,
                              @RequestParam(required = false,name="name") String newName,
                              @RequestParam(required = false,name="lastname") String newLastname,
                              @RequestParam(required = false,name="email") String newEmail,
                              @RequestParam(required = false,name="dni") String newDni) {
        customerService.editCustomer(id_customer,newName,newLastname,newEmail,newDni);
        return  "Customer updated successfully";
    }

    }
