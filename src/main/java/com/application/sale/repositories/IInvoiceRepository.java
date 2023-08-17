package com.application.sale.repositories;

import com.application.sale.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInvoiceRepository extends JpaRepository<Invoice,Long> {
}
