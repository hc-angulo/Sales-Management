package com.application.sale.services;

import com.application.sale.models.Product;

import java.math.BigDecimal;
import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void saveProduct(Product product);
    Product findById(Long id_product);
    List<Product> findByWords(String words);
    List<Product> productsOutOfStock();
    // --- List<Product> findByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);
    List<Product> findByPriceRange(double minPrice, double maxPrice);
    void deleteProduct(Long id_producto);
    // --- void editProduct(Long id_product,String newName,String newBrand,BigDecimal newPrice,int newQuantity);
    void editProduct(Long id_product,String newName,String newBrand,double newPrice,int newQuantity);


}
