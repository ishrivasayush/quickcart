package com.tier3Hub.quickCart.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name",nullable = false,length = 100)
    private String name;

    @Column(nullable = false,name = "description")
    private String description;

    @Column(name = "image",columnDefinition = "LONGBLOB")
    @Lob
    private String image;

    @Column(name = "status")
    private boolean status;

    @Column(name = "price",nullable = false)
    private double price;

    @Column(name="discount")
    private double discount;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "special_price")
    private double specialPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
    private List<CartItem> products = new ArrayList<>();

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;


}
