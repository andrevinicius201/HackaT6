package com.safra.safrat6.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.safra.safrat6.model.Account;
import com.safra.safrat6.model.Invite;
import com.safra.safrat6.model.Prize;
import com.safra.safrat6.model.Sticker;
import com.safra.safrat6.model.Transaction;

@RestController
@RequestMapping("/accounts")
public class AccountController {
  
  @GetMapping(value = "/{id}")
  public ResponseEntity<Object> getAccount(@PathVariable("id") String id) {
    try {
      Account account = new Account();
      // TODO
      return new ResponseEntity<>(account, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping(value = "/{id}/prizes")
  public ResponseEntity<Object> postPrize(@Validated @RequestBody Prize prize, @PathVariable("id") String id) {
    try {
      // TODO
      return new ResponseEntity<>(prize, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping(value = "/{id}/transactions")
  public ResponseEntity<Object> postTransaction(@Validated @RequestBody Transaction transaction, @PathVariable("id") String id) {
    try {
      // TODO
      return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping(value = "/{id}/stickers")
  public ResponseEntity<Object> getStickers(@PathVariable("id") String id) {
    try {
      List<Sticker> stickers = new ArrayList<>();
      // TODO
      return new ResponseEntity<>(stickers, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping(value = "/{id}/invites")
  public ResponseEntity<Object> postInvite(@Validated @RequestBody Invite invite, @PathVariable("id") String id) {
    try {
      // TODO
      return new ResponseEntity<>(invite, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping(value = "/{id}/invites")
  public ResponseEntity<Object> getInvites(@PathVariable("id") String id) {
    try {
      List<Invite> invites = new ArrayList<>();
      // TODO
      return new ResponseEntity<>(invites, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

}
