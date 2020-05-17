package com.bl.springbootbookstore.service;

import com.bl.springbootbookstore.model.Book;
import com.bl.springbootbookstore.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class UserBookServiceImpl implements IUserBookService{

    @Autowired
    IBookRepository bookRepository;

    List<Book> bookList = new ArrayList<Book>();

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

    @Override
    public List<Book> sortBooks(String sortField) {
        bookList = getBookList();
        sortField.toLowerCase();
        Comparator<Book> bookComparator;
        switch (sortField){
            case "relevance":
                return bookList;
            case "price: low to high":
                bookComparator = Comparator.comparing(Book -> Book.price);
                this.sortDataAscending(bookComparator);
                break;
            case "price: high to low":
                bookComparator = Comparator.comparing(Book -> Book.price);
                this.sortDataDescending(bookComparator);
                break;
            case "newest arrivals":
                bookComparator = Comparator.comparing(Book -> Book.id);
                this.sortDataAscending(bookComparator);
                Collections.reverse(bookList);
                break;
        }
        return bookList;
    }

    private  void sortDataAscending(Comparator<Book> bookComparator){
        for (int i = 0; i < bookList.size(); i++){
            for (int j = 0; j < bookList.size() - i - 1; j++) {
                Book book1 = bookList.get(j);
                Book book2 = bookList.get(j + 1);
                if (bookComparator.compare(book1,book2) > 0){
                    bookList.set(j, book2);
                    bookList.set(j+1, book1);
                }
            }
        }
    }

    private  void sortDataDescending(Comparator<Book> bookComparator){
        for (int i = 0; i < bookList.size(); i++){
            for (int j = 0; j < bookList.size() - i - 1; j++) {
                Book book1 = bookList.get(j);
                Book book2 = bookList.get(j + 1);
                if (bookComparator.compare(book1,book2) < 0){
                    bookList.set(j, book2);
                    bookList.set(j+1, book1);
                }
            }
        }
    }

}
