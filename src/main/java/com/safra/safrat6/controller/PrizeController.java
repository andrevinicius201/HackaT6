package com.safra.safrat6.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safra.safrat6.model.Prize;


@RestController
@RequestMapping("/prize")
public class PrizeController {
	
	  @PostMapping(value = "choose")
	  public ResponseEntity<Object> postChoose(
	      @Validated @RequestBody Prize prize) {
	    try {
	      // TODO
	      return new ResponseEntity<>(prize, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	  }
	  
	  
	  @PostMapping(value = "uploadImage")
	  public ResponseEntity<Object> uploadImage(
	      @Validated @RequestBody Prize prize) {
	    try {
	      // TODO
	      return new ResponseEntity<>(prize, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	  }
	  

}
