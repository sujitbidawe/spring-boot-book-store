package com.bl.springbootbookstore.model;

import javax.persistence.*;
@Entity
@Table(name = Book.TABLE_NAME)
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

    public Book() {
    }

    public Book(int id, String authorName, String bookTitle, String image, double price, String description, int bookCount) {
        this.id = id;
        this.authorName = authorName;
        this.bookTitle = bookTitle;
        this.image = image;
        this.price = price;
        this.description = description;
        this.bookCount = bookCount;
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
