package com.bl.springbootbookstore.service;

import com.bl.springbootbookstore.model.Book;
import com.bl.springbootbookstore.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserBookServiceImpl implements IUserBookService{

    @Autowired
    IBookRepository bookRepository;

    @Override
    public List<Book> getBookList() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> searchBooks(String searchText) {
        List<Book> bookList = getBookList();
        List<Book> searchList = new ArrayList<>();
        for (int book = 0; book < bookList.size(); book++) {
            if (bookList.get(book).authorName.toLowerCase().contains(searchText.toLowerCase()) ||
                    bookList.get(book).bookTitle.toLowerCase().contains(searchText.toLowerCase())){
                searchList.add(bookList.get(book));
            }
        }
        return searchList;
    }
}
