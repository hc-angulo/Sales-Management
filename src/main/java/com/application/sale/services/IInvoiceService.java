package com.application.sale.services;

import com.application.sale.models.Customer;
import com.application.sale.models.Invoice;
import com.application.sale.models.Invoice_Product;

import java.time.LocalDate;
import java.util.List;

public interface IInvoiceService {
    public List<Invoice> findAll();
    public void saveInvoice(Invoice invoice);
    public Invoice findById(Long id_invoice);
    public void deleteInvoice(Long id_invoice);

    public void editInvoice(Long id_invoice,
                            LocalDate newDate,
                            Customer newCustomer,
                            List<Invoice_Product>invoiceProductList);

}
