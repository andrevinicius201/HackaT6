package com.safra.safrat6.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
// import com.safra.safrat6.service.StickerService;

import com.safra.safrat6.listener.JSON.TransactionJSON;

@Component
@RabbitListener(queues = "transaction")
public class TransactionListener {

  // @Autowired
  // private StickerService stickerService;

  @RabbitHandler
  public void receiveMessage(TransactionJSON transaction) {
    //TODO all stickers generation
  }
}
