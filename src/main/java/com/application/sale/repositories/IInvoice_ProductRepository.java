package com.application.sale.repositories;

import com.application.sale.models.Invoice_Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInvoice_ProductRepository extends JpaRepository<Invoice_Product,Long> {
}
