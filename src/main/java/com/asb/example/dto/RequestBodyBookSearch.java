package com.asb.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestBodyBookSearch {

    private String name = "";
    private String author  = "";
    private String publishHouse = "";

}
