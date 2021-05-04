package com.asb.example.controller;

import com.asb.example.entity.Book;
import com.asb.example.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/add-book")
    public HttpStatus postModelToKafka(@RequestBody Book book) {
        kafkaProducerService.postModelToKafka(book);
        return HttpStatus.OK;
    }
}