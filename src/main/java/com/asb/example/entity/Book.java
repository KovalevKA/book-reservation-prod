package com.asb.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;


@Data
public class Book {

    public static final String INDEX = "books";

    @JsonIgnore
    private String id;

    @JsonProperty("isbn")
    private String isbn;
    @JsonProperty("name")
    private String name;
    @JsonProperty("publishHouse")
    private String publishHouse;
    @JsonProperty("publishYear")
    private int publishYear;
    private String description;
    private List<Author> authors;
    private List<Genre> genres;
    private List<Translator> translators;
}
