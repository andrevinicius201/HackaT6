package com.safra.safrat6.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.safra.safrat6.service.StickerService;

@Component
@RabbitListener(queues = "transactions")
public class TransactionListener {
  
  @Autowired
  private StickerService stickerService;

  @RabbitHandler
  public void receive(byte[] message) {
    System.out.println("RECEBI ALGO");
  }
}
