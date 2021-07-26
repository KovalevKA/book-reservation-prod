package com.asb.example.repository;

import com.asb.example.entity.Book;
import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends ElasticsearchRepository<Book, String> {

    List<Book> findByNameContainingOrAuthorsContaining(String name, String authors);

}
