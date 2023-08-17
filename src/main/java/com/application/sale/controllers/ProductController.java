package com.application.sale.controllers;

import com.application.sale.models.Product;
import com.application.sale.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    IProductService productService;
    @GetMapping("")
    public List<Product> findAll(){
        return productService.findAll();
    }
    @PostMapping("/create")
    public String saveProduct(@RequestBody Product product){
        productService.saveProduct(product);
        return "Product create successfully";
    }

    @GetMapping("/{id_product}")
    public Product findProductById(@PathVariable Long id_product){
        return productService.findById(id_product);
    }
   @GetMapping("/find_by_Words/{words}")
    public List<Product> findProductByWords(@PathVariable String words){
        return productService.findByWords(words);
    }

   @GetMapping("/out_of_stock")
    public List<Product> findProductsOutOfStock(){
        return productService.productsOutOfStock();
    }

    /*@GetMapping("/price_range")
    public List<Product> findProductByPriceRange(@RequestParam BigDecimal minPrice, @RequestParam BigDecimal maxPrice){
        return productService.findByPriceRange(minPrice,maxPrice);
    }*/

    @GetMapping("/price_range")
    public List<Product> findProductByPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice){
        return productService.findByPriceRange(minPrice,maxPrice);
    }
    @DeleteMapping("/delete/{id_producto}")
    public String deleteProduct(@PathVariable Long id_producto) {
        productService.deleteProduct(id_producto);
        return "Product deleted successfully";
    }

    /*@PutMapping("/edit/{id_product}")
    public String editProduct(@PathVariable Long id_product,
                              @RequestParam(required = false,name="name") String newName,
                              @RequestParam(required = false,name="brand") String newBrand,
                              @RequestParam(required = false,name="price") BigDecimal newPrice,
                              @RequestParam(required = false,name="quantity") int newQuantity) {
        productService.editProduct(id_product,newName,newBrand,newPrice,newQuantity);
        return  "Product updated successfully";
    }*/
    @PutMapping("/edit/{id_product}")
    public String editProduct(@PathVariable Long id_product,
                              @RequestParam(required = false,name="name") String newName,
                              @RequestParam(required = false,name="brand") String newBrand,
                              @RequestParam(required = false,name="price") double newPrice,
                              @RequestParam(required = false,name="quantity") int newQuantity) {
        productService.editProduct(id_product,newName,newBrand,newPrice,newQuantity);
        return  "Product updated successfully";
    }
}
