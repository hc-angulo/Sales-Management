package com.application.sale.repositories;

import com.application.sale.models.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {
    @Transactional
    @Query("SELECT p FROM Product p WHERE UPPER(p.brand) LIKE UPPER(concat('%', ?1, '%')) OR UPPER(p.name) LIKE UPPER(concat('%', ?1, '%'))")
    List<Product> findByWords(String words);
    @Transactional
    @Query("SELECT p FROM Product p WHERE p.quantity < 5")
    List<Product> productsOutOfStock();
    @Transactional
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN ?1 AND ?2")
    // --- List<Product> findByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);
    List<Product> findByPriceRange(double minPrice, double maxPrice);


}
