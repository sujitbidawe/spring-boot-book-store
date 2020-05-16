package com.bl.springbootbookstore.service;

import com.bl.springbootbookstore.model.Book;
import com.bl.springbootbookstore.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBookServiceImpl implements IUserBookService{

    @Autowired
    IBookRepository bookRepository;

    @Override
    public List<Book> getBookList() {
        return bookRepository.findAll();
    }
}
