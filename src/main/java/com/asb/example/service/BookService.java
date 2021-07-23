package com.asb.example.service;


import com.asb.example.dto.RequestBodyBookSearch;
import com.asb.example.entity.Book;
import com.asb.example.repository.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book add(Book book) {
        return bookRepository.save(book);
    }

    public Iterable<Book> search(RequestBodyBookSearch requestBodyBookSearch) {
        return bookRepository.findAll();
    }

}
