package com.bl.springbootbookstore.service;

import com.bl.springbootbookstore.model.Book;
import com.bl.springbootbookstore.repository.IBookRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class AdminBookServiceImpl implements IAdminBookService {

    @Autowired
    IBookRepository bookRepository;

    @Autowired
    Book book;

    @Override
    public String addBook(String path){
        String[] nextLine;
        Reader reader = null;
        int countOfRowsAdded = 0;
        try {
            reader = Files.newBufferedReader(Paths.get(path));
            System.out.println(reader);
            CSVReaderBuilder readerBuilder = new CSVReaderBuilder(reader);
            CSVReader csv = readerBuilder.withSkipLines(1).build();
            while ((nextLine = csv.readNext()) != null) {
                countOfRowsAdded++;
                book.bookCount = 10;
                book.id = Integer.parseInt(nextLine[0]);
                book.authorName = nextLine[1].replaceAll("'", "");
                book.bookTitle = nextLine[2].replaceAll("'", "");
                book.image = nextLine[3].replaceAll("'", "");
                book.price = Double.parseDouble(nextLine[4]);
                StringBuilder stringBuilder = new StringBuilder();
                for (int column = 5; column < nextLine.length; column++) {
                    stringBuilder.append(nextLine[column]);
                }
                book.description = stringBuilder.toString().replaceAll("'", "");
                bookRepository.save(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countOfRowsAdded + " Books added successfully!";
    }
}

