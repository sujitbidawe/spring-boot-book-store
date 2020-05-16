package com.bl.springbootbookstore.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
@Component
@Entity
@Table
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String authorName;
    public String bookTitle;
    public String image;
    public double price;
    @Column(length = 3000)
    public String description;
    public int bookCount;

    public Book() {
    }

    public Book(int id, String authorName, String bookTitle, String image, double price, String description, int bookCount) {
        this.id = id;
        this.authorName = authorName;
        this.bookTitle = bookTitle;
        this.image = image;
        this.price = price;
        this.description = description;
        this.bookCount = 10;
    }

    public Book(int id, String authorName, String bookTitle, String image, double price, String description) {
        this.id = id;
        this.authorName = authorName;
        this.bookTitle = bookTitle;
        this.image = image;
        this.price = price;
        this.description = description;
    }

    public Book(int id, String bookTitle, double price, int bookCount) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.price = price;
        this.bookCount = bookCount;
    }

    public Book(Book book) {

    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", bookCount=" + bookCount +
                '}';
    }
}
