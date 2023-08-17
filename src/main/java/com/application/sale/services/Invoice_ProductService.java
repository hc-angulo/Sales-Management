package com.application.sale.services;

import com.application.sale.models.Invoice;
import com.application.sale.models.Invoice_Product;
import com.application.sale.models.Product;
import com.application.sale.repositories.IInvoiceRepository;
import com.application.sale.repositories.IInvoice_ProductRepository;
import com.application.sale.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class Invoice_ProductService implements IInvoice_ProductService {
    @Autowired
    IInvoice_ProductRepository invoice_productRepository;
    @Autowired
    IProductRepository productRepository;
    @Autowired
    IInvoiceRepository invoiceRepository;

    @Override
    public List<Invoice_Product> findInvoiceProductList(){
        List<Invoice_Product> invoiceProductList= invoice_productRepository.findAll();
        return invoiceProductList;
    }
    public Invoice_Product findByIdInvoiceDetail(Long id){
        Invoice_Product invoiceProduct = invoice_productRepository.findById(id).orElse(null);
        return invoiceProduct;
    }
    @Override
    public void saveInvoiceProduct(Invoice_Product invoiceProduct) {
        invoice_productRepository.save(invoiceProduct);
        this.invoiceUpdateInAmountColumn(invoiceProduct);
        this.productUpdateInQuantityColumn(invoiceProduct);

    }
    @Override
    public void deleteInvoiceProduct(Long id) {
        Invoice_Product invoiceProduct = this.findByIdInvoiceDetail(id);
       this.invoiceUpdateInAmountColumn(invoiceProduct);
       this.productUpdateInQuantityColumn(invoiceProduct);
        invoice_productRepository.deleteById(id);
    }

    public void productUpdateInQuantityColumn(Invoice_Product invoiceProduct){
        Product product = productRepository.findById(invoiceProduct.getProduct().getId()).orElse(null);
        if(product!=null){
            int newQuantity = product.getQuantity()-invoiceProduct.getQuantity();
            if(newQuantity >= 0){
                product.setQuantity(newQuantity);
                productRepository.save(product);
            }
        }else{
            return;
        }
    }

    public void invoiceUpdateInAmountColumn(Invoice_Product invoiceProduct) {
        List<Invoice_Product> invoiceProductList = this.findInvoiceProductList();
        Invoice invoice = invoiceRepository.findById(invoiceProduct.getInvoice().getId()).orElse(null);
        Product product = productRepository.findById(invoiceProduct.getProduct().getId()).orElse(null);

       if (!invoiceProductList.isEmpty()) {
            double addition = 0;
            for (Invoice_Product IP : invoiceProductList) {
                if (IP.getInvoice().getId().equals(invoiceProduct.getInvoice().getId())) {
                    double precioProducto = product.getPrice();
                    addition +=IP.getQuantity()*precioProducto;
                }
            }
            invoice.setAmount(addition);
            invoiceRepository.save(invoice);
       }
    }
}
