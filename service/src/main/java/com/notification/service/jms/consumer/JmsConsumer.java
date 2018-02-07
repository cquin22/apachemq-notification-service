package com.notification.service.jms.consumer;

import com.notification.service.model.Transaction;
import com.notification.service.repository.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;



@Component
public class JmsConsumer {

	@Autowired
	ITransactionRepository transactionRepository;
	
	@JmsListener(destination = "${jsa.activemq.queue}", containerFactory="jsaFactory")
	public void receive(Transaction transaction){
		try {
			transactionRepository.save(transaction);
			System.out.println("Recieved Message: " + transaction);
		}catch (Exception e){
			System.out.println("error saving the transaction error message is: " + e.getMessage());
		}


	}
}
