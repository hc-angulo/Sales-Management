package com.application.sale.repositories;

import com.application.sale.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {

}
