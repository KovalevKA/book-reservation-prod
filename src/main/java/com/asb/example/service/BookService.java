package com.asb.example.service;


import com.asb.example.dto.RequestBodyBookSearch;
import com.asb.example.entity.Book;
import com.asb.example.repository.BookRepository;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book add(Book book) {
        return bookRepository.save(book);
    }

    public void delete(String id) {
        bookRepository.deleteById(id);
    }

    public Book update(String id, Book book) throws NotFoundException {
        Book bookToSave = bookRepository.findById(id).orElseThrow(() -> new NotFoundException());
        Arrays.stream(bookToSave.getClass().getFields()).forEach(field -> {
            field.setAccessible(true);
            try {
                ReflectionUtils.setField(field, bookToSave,
                    book.getClass().getField(field.getName()).get(book));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        });
        return bookRepository.save(bookToSave);
    }

    public List<Book> search(RequestBodyBookSearch requestBodyBookSearch) {
        return bookRepository
            .findByNameContainingOrAuthorsContaining(requestBodyBookSearch.getName(),
                requestBodyBookSearch.getAuthor());
    }

}
