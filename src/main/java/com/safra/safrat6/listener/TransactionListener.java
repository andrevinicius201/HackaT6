package com.safra.safrat6.listener;

import java.time.LocalDateTime;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
// import com.safra.safrat6.service.StickerService;

import com.safra.safrat6.listener.JSON.TransactionJSON;
import com.safra.safrat6.model.Transaction;
import com.safra.safrat6.service.StickerService;

@Component
@RabbitListener(queues = "transaction")
public class TransactionListener {

  @Autowired
  private StickerService stickerService;

  @RabbitHandler
  public void receiveMessage(TransactionJSON json) {
	  Transaction transaction = new Transaction();
	  transaction.setAccountId(json.getAccountId());
	  transaction.setTransactionId(json.getTransactionId());
	  transaction.setTransactionInformation(json.getTransactionInformation().toString());
	  transaction.setValue(json.getValue());
	  
	  final LocalDateTime date = LocalDateTime.now();
	  transaction.setDate(date);
	  // TODO fix date serialization with LocalDateTime
	  // transaction.setDate(json.getDate());
	  try {
     stickerService.distributeStickers(transaction, json.getTransactionInformation());
	  } catch(Exception e) {
		  //System.out.println(e.getMessage() ); 
	  }
  }
}
