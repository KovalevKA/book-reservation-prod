package com.asb.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Book {

    private String isbn;
    private String name;
    private String publishHouse;
    private int publishYear;
    private String description;
    private Set<Author> authors = new HashSet<>();
    private Set<Genre> genres = new HashSet<>();
    private Set<Translator> translators = new HashSet<>();
}
