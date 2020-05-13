package com.bl.springbootbookstore.repository;

import com.bl.springbootbookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Integer> {
}
