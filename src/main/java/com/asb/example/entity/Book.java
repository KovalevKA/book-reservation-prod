package com.asb.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Book {

    private String name;
    private String publishHouse;
    private int publishYear;
    private String description;
    private List<Author> authors;
    private List<Genre> genres;
    private List<Translator> translators;
}
