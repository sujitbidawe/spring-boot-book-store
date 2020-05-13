package com.bl.springbootbookstore.service;

import com.bl.springbootbookstore.model.Book;
import com.bl.springbootbookstore.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    IBookRepository iBookRepository;

    public void addBook(Book book){

        iBookRepository.save(book);
    }
}

