package com.application.sale.controllers;

import com.application.sale.models.Customer;
import com.application.sale.models.Invoice;
import com.application.sale.models.Invoice_Product;
import com.application.sale.models.Product;
import com.application.sale.services.IInvoiceService;
import com.application.sale.services.IInvoice_ProductService;
import com.application.sale.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {
    @Autowired
    IInvoiceService invoiceService;

    @Autowired
    IInvoice_ProductService invoice_product;

    @Autowired
    IProductService productService;

    @GetMapping("")
    public List<Invoice> findAll(){
        return invoiceService.findAll();
    }

    @PostMapping("/create")
    public String saveInvoice(@RequestBody Invoice invoice){
        invoiceService.saveInvoice(invoice);
        return "Invoice created successfully!";
    }
    @GetMapping("/{id_invoice}")
    public Invoice findInvoiceById(@PathVariable Long id_invoice){
        return invoiceService.findById(id_invoice);
    }

    @DeleteMapping("/delete/{id_invoice}")
    public String deleteInvoice(@PathVariable Long id_invoice) {
        invoiceService.deleteInvoice(id_invoice);
        return "Invoice deleted successfully";
    }

    @PutMapping("/edit/{id_invoice}")
    public String editInvoice(@PathVariable Long id_invoice,
                               @RequestParam(required = false,name="date") LocalDate newDate,
                               @RequestParam(required = false,name="customer") Customer newCustomer,
                               @RequestParam(required = false,name="invoiceProductList") List<Invoice_Product> invoiceProductList) {
        invoiceService.editInvoice(id_invoice,newDate,newCustomer,invoiceProductList);
        return  "Invoice updated successfully";
    }

    @GetMapping("/invoice_detail")
   public List<Invoice_Product> findInvoiceProductList(){
       return invoice_product.findInvoiceProductList();
   }

    @PostMapping("/create/invoice_detail")
    public void createInvoiceDetail(@RequestBody Invoice_Product invoiceProduct){
        invoice_product.saveInvoiceProduct(invoiceProduct);
    }

    @GetMapping("/invoice_detail/{id_invoiceProduct}")
    public Invoice_Product findByIdInvoiceDetail(@PathVariable Long id_invoiceProduct) {
        return invoice_product.findByIdInvoiceDetail(id_invoiceProduct);
    }
    @DeleteMapping("/delete/invoice_detail/{id_invoiceProduct}")
    public String deleteInvoiceProduct(@PathVariable Long id_invoiceProduct){
        invoice_product.deleteInvoiceProduct(id_invoiceProduct);
        return "Product invoice deleted successfully";
    }





}
