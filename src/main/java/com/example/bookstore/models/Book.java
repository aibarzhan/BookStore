package com.example.bookstore.models;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Book {

    private UUID id;
    private String title;
    private String author;
    private BigDecimal price;

    public Book () {
        this.id = UUID.randomUUID();
    }
}
