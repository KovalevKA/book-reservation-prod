package com.asb.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Document(indexName = Book.INDEX)
@Data
public class Book {

    public static final String INDEX = "books";

    @Id
    private String id;

    @JsonProperty("name")
    @Field(type = FieldType.Text)
    private String name;
    @JsonProperty("publishHouse")
    @Field(type = FieldType.Text)
    private String publishHouse;
    @Field(type = FieldType.Integer)
    @JsonProperty("publishYear")
    private int publishYear;
    @Field(type = FieldType.Text)
    private String description;
    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Author> authors;
    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Genre> genres;
    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Translator> translators;
}
