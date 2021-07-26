package com.asb.example.controller;

import com.asb.example.dto.RequestBodyBookSearch;
import com.asb.example.entity.Book;
import com.asb.example.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("add")
    public Book add(@RequestBody Book book) {
        return bookService.add(book);
    }

    @PostMapping("delete/{id}")
    public void delete(@PathVariable String id) {
        bookService.delete(id);
    }

    @PostMapping("update/{id}")
    public Book update(@PathVariable String id, @RequestBody Book book) throws NotFoundException {
        return bookService.update(id, book);
    }

    @PostMapping("search")
    public List<Book> search(@RequestBody RequestBodyBookSearch requestBodyBookSearch) {
        return bookService.search(requestBodyBookSearch);
    }

}
