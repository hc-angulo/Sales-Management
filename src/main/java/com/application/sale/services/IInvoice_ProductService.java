package com.application.sale.services;

import com.application.sale.models.Invoice_Product;

import java.util.List;

public interface IInvoice_ProductService {
    List<Invoice_Product> findInvoiceProductList();
    void saveInvoiceProduct(Invoice_Product invoiceProduct);

    Invoice_Product findByIdInvoiceDetail(Long id);
    void deleteInvoiceProduct(Long id);



}
