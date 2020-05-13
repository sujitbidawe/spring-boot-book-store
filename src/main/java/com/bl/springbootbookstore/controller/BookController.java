package com.bl.springbootbookstore.controller;

import com.bl.springbootbookstore.model.Book;
import com.bl.springbootbookstore.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    IBookService iBookService;
    @PostMapping("/book")
    public String addBook(@RequestBody Book book){
        iBookService.addBook(book);
        return "Book Added into database";
    }


}
