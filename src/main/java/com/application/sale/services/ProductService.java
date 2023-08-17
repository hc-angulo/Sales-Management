package com.application.sale.services;

import com.application.sale.models.Product;
import com.application.sale.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class ProductService implements IProductService{
    @Autowired
    IProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(Long id_product) {
        Product product = productRepository.findById(id_product).orElse(null);
        return product;
    }
    @Override
    public List<Product> findByWords(String words) {
        return productRepository.findByWords(words);
    }

    @Override
    public List<Product> productsOutOfStock() {
        return productRepository.productsOutOfStock();
    }

    /*@Override
    public List<Product> findByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productRepository.findByPriceRange(minPrice,maxPrice);
    }*/

    @Override
    public List<Product> findByPriceRange(double minPrice, double maxPrice) {
        return productRepository.findByPriceRange(minPrice,maxPrice);
    }

    @Override
    public void deleteProduct(Long id_producto) {
        productRepository.deleteById(id_producto);
    }

   /* @Override
    public void editProduct(Long id_product, String newName, String newBrand, BigDecimal newPrice, int newQuantity) {
           Product product = this.findById(id_product);
           product.setName(newName);
           product.setBrand(newBrand);
           product.setPrice(newPrice);
           product.setQuantity(newQuantity);
           this.saveProduct(product);
    }*/

    @Override
    public void editProduct(Long id_product, String newName, String newBrand, double newPrice, int newQuantity) {
        Product product = this.findById(id_product);
        product.setName(newName);
        product.setBrand(newBrand);
        product.setPrice(newPrice);
        product.setQuantity(newQuantity);
        this.saveProduct(product);
    }
}
