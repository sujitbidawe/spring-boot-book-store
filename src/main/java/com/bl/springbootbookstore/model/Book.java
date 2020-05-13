package com.bl.springbootbookstore.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table(name = Book.TABLE_NAME)
@Getter
@Setter
public class Book {
    public static final String TABLE_NAME= "books";
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String authorName;
    String bookTitle;
    String image;
    double price;
    String description;
    int bookCount;

//    public Book(int id, String bookTitle, String imageUrl, double price, String description, int bookCount) {
//        this.id = id;
//        this.bookTitle = bookTitle;
//        this.imageUrl = imageUrl;
//        this.price = price;
//        this.description = description;
//        this.bookCount = bookCount;
//    }
}
