package com.asb.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Genre {

    public static final String INDEX = "genres";

    private String id;
    @JsonProperty("name")
    private String name;
}
