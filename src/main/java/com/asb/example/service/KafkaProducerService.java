package com.asb.example.service;

import com.asb.example.entity.Book;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private Gson gson;

    public ListenableFuture<SendResult<String, String>> postModelToKafka(Book book) {
        ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send("book-add-topic", gson.toJson(book));
        return result;
    }


}
