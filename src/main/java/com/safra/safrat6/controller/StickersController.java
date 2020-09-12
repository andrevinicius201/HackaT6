package com.safra.safrat6.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safra.safrat6.model.Sticker;


@RestController
@RequestMapping("/stickers")
public class StickersController {
	
	
	  @PostMapping(value = "generate")
	  public ResponseEntity<Object> postGenerate(
	      @Validated @RequestBody Sticker sticker) {
	    try {
	      // TODO
	      return new ResponseEntity<>(sticker, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	  }
	  
	  @GetMapping(value = "collection/{accountHolderId}")
	  public ResponseEntity<Object> getCollection(
	      @Validated @RequestBody Sticker sticker) {
	    try {
	      // TODO
	      return new ResponseEntity<>(sticker, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	  }
	  
	  @PostMapping(value = "buy")
	  public ResponseEntity<Object> postBuy(
	      @Validated @RequestBody Sticker sticker) {
	    try {
	      // TODO
	      return new ResponseEntity<>(sticker, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	  }
}
