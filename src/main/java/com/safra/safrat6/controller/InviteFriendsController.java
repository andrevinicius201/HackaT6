package com.safra.safrat6.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safra.safrat6.model.Invite;


@RestController
@RequestMapping("/inviteFriends")
public class InviteFriendsController {
	
	  @PostMapping(value = "")
	  public ResponseEntity<Object> postInvite(
	      @Validated @RequestBody Invite invite) {
	    try {
	      // TODO
	      return new ResponseEntity<>(invite, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	  }

}
