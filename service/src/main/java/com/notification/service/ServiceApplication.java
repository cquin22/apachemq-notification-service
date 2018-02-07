package com.notification.service;

import com.notification.service.jms.producer.JmsProducer;
import com.notification.service.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ServiceApplication {

	@Autowired
	JmsProducer producer;

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}
}
