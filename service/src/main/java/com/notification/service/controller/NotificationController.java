package com.notification.service.controller;

import com.notification.service.jms.producer.JmsProducer;
import com.notification.service.model.Transaction;
import com.notification.service.repository.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.JmsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    JmsProducer producer;

    @Autowired
    ITransactionRepository transactionRepository;

    private static Transaction mainTransaction = new Transaction();

    @RequestMapping(value = "/{transactionCode}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getNotification(@PathVariable("transactionCode") Integer transactionCode){
        try {
            Transaction transaction = transactionRepository.findByTransactionCode(transactionCode);
            return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>("Obteniendo el valor almacenado con la notificaci[on" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sendNotification(@RequestBody Transaction transaction){
        try {
            mainTransaction = transaction;
            completeBranchOfficeCode();
            completeAccountBalance();
            completeCodeSCA();
            producer.send(mainTransaction);
            return new ResponseEntity<String>("Mensaje añadido a la cola de mansajes correctamente", HttpStatus.OK);
        }
        catch (JmsException e){
            return new ResponseEntity<String>("Error parseando el tempalte" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (Exception e){
            return new ResponseEntity<String>("Error enviando mensaje a la cola " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void completeBranchOfficeCode(){
        if(mainTransaction.getBranchOfficeCode() == null){
            mainTransaction.setBranchOfficeCode(mainTransaction.getCashierId());
        }
    }

    private void completeAccountBalance(){
        if(Objects.isNull(mainTransaction.getAccountBalance())){
            long defaultAccount = 0000000000000;
            mainTransaction.setAccountBalance(defaultAccount);
        }
    }

    private void completeCodeSCA(){
        if(mainTransaction.getAccountBalance() < 0) {
            mainTransaction.setCodeSCA("-");
        }else if(mainTransaction.getAccountBalance() >= 0){
            mainTransaction.setCodeSCA("+");
        }
    }
}
