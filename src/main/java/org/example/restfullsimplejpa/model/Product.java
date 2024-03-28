package org.example.restfullsimplejpa.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="product_tbl")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private float price;
}
