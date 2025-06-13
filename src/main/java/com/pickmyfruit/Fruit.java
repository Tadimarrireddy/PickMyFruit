package com.pickmyfruit;

import jakarta.persistence.*;

@Entity
@Table(name = "FRUITS")
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fruit_seq_gen")
    @SequenceGenerator(name = "fruit_seq_gen", sequenceName = "FRUIT_SEQ", allocationSize = 1)
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PRICE", nullable = false)
    private double price;

    @Column(name = "QUANTITY")  // ✅ New column for quantity as String
    private String quantity;

    public Fruit() {
    }

    // ✅ Constructor with quantity
    public Fruit(Integer id, String name, double price, String quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // ✅ Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
