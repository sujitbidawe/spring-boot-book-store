package com.bl.springbootbookstore.controller;

import com.bl.springbootbookstore.service.IUserBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    IUserBookService userBookService;

    @GetMapping("/home")
    public ResponseEntity getBooks(){
        return new ResponseEntity(userBookService.getBookList(), HttpStatus.OK);
    }

    @GetMapping("/home-search")
    public ResponseEntity searchBooks(@RequestParam String searchText){
        return new ResponseEntity(userBookService.searchBooks(searchText), HttpStatus.OK);
    }

}
