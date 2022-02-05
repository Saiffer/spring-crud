package com.example.demo.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name= "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long internalId;

    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private double price;
    @Getter
    @Setter
    private String id;



}
