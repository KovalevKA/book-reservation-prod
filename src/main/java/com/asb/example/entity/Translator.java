package com.asb.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Document(indexName = Translator.INDEX)
public class Translator {

    public static final String INDEX = "translators";

    @Id
    private String id;
    @JsonProperty("name")
    @Field(type = FieldType.Text)
    private String name;
}
