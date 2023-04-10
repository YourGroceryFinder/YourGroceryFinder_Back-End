package dev.danvega.classes;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;

    @Column(name = "Name")
    String name;

    @Column(name = "imglink")
    String imgLink;

    @Column(name = "Price")
    String price;

    @Column(name = "Store")
    String storeName;
}
