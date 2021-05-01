package com.asb.example.controller;

import java.util.concurrent.ExecutionException;

import com.asb.example.entity.Book;
import com.asb.example.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {

	@Autowired
	private  KafkaProducerService kafkaProducerService;

	@PostMapping("/add-book")
	public String postModelToKafka(@RequestBody Book book)
			throws InterruptedException, ExecutionException {
		return kafkaProducerService.postModelToKafka(book).get().getProducerRecord().value();
	}
}