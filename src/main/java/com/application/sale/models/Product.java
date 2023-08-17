package com.application.sale.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="producto")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="nombre")
    private String name;
    @Column(name="marca")
    private String brand;
    @Column(name="costo")
    // --- private BigDecimal price;
    private double price;
    @Column(name="cantidad_disponible")
    private int quantity;


    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Invoice_Product> invoiceProductList;

}
