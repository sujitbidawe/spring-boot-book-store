package com.bl.springbootbookstore.service;

import com.bl.springbootbookstore.model.Book;

import java.util.List;

public interface IUserBookService {
    List<Book> getBookList();
    List<Book> searchBooks(String searchText);
}
