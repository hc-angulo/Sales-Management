package com.application.sale.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
@Entity
@Table(name="cliente")
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="nombre")
    private String name;
    @Column(name="apellido")
    private String lastname;
    @Column(name="email")
    private String email;
    @Column(name="dni")
    private String dni;
    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Invoice> invoices;


}
