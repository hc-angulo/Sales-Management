package com.application.sale.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="factura")
@Getter @Setter
public class Invoice {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="fecha_de_venta")
    private LocalDate date;

    @Column(name="monto_a_pagar")
    // --- private BigDecimal amount = BigDecimal.ZERO;
    private double amount;
    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Customer customer;

    @OneToMany(mappedBy = "invoice")
    @JsonIgnore
    private List<Invoice_Product> invoiceProductList = new ArrayList<>();




}

