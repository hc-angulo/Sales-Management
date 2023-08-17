package com.application.sale.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="detalle_de_factura")
public class Invoice_Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="cantidad")
    private int quantity;

    @ManyToOne
    @JoinColumn(name="id_factura")
    //@JsonIgnore
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name="id_producto")
    //@JsonIgnore
    private Product product;

}
