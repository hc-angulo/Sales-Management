package com.application.sale.services;

import com.application.sale.models.Customer;

import java.util.List;

public interface ICustomerService {
    public List<Customer> findAll();
    public void saveCustomer(Customer customer);
    public Customer findById(Long id_customer);

    public void deleteCustomer(Long id_customer);

    public void editCustomer(Long id_customer,String nuevoNombre,
                            String nuevoApellido,String nuevoEmail,
                            String nuevoDni);

}
