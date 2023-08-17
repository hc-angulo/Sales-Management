package com.application.sale.services;

import com.application.sale.models.Customer;
import com.application.sale.models.Invoice;
import com.application.sale.models.Invoice_Product;
import com.application.sale.repositories.IInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InvoiceService implements IInvoiceService {
    @Autowired
    IInvoiceRepository invoiceRepository;
    @Override
    public List<Invoice> findAll() {
        List<Invoice> invoices = invoiceRepository.findAll();
        return invoices;
    }

    @Override
    public void saveInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    @Override
    public Invoice findById(Long id_invoice) {
        Invoice invoice = invoiceRepository.findById(id_invoice).orElse(null);
        return invoice;
    }

    @Override
    public void deleteInvoice(Long id_invoice) {
        invoiceRepository.deleteById(id_invoice);
    }

    @Override
    public void editInvoice(Long id_invoice, LocalDate newDate, Customer newCustomer, List<Invoice_Product> invoiceProductList) {
        Invoice invoice = this.findById(id_invoice);
        invoice.setDate(newDate);
        invoice.setCustomer(newCustomer);
        invoice.setInvoiceProductList(invoiceProductList);
        this.saveInvoice(invoice);
    }
}
