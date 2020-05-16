package com.bl.springbootbookstore.controller;

import com.bl.springbootbookstore.service.IAdminBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @Autowired
    IAdminBookService bookService;

    @PostMapping("/admin/bookInsertByCsv")
    public ResponseEntity insertBooksDataFromCsv(@RequestParam String path) {
        return new ResponseEntity(bookService.addBook(path), HttpStatus.CREATED);
    }

}
