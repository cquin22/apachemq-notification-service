package com.notification.service.jms.producer;

import com.notification.service.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;



@Component
public class JmsProducer {
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Value("${jsa.activemq.queue}")
	String queue;
	
	public void send(Transaction transaction) throws JmsException {
		jmsTemplate.convertAndSend(queue, transaction);
	}
}