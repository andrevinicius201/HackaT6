package com.safra.safrat6.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.safra.safrat6.model.Prize;


@RestController
@RequestMapping("/prizes")
public class PrizeController {

  @PostMapping(value = "")
  public ResponseEntity<Object> postPrize(@Validated @RequestBody Prize prize,
      @RequestParam MultipartFile file) {
    try {
      // TODO
      return new ResponseEntity<>(prize, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping(value = "")
  public ResponseEntity<Object> getPrizes() {
    try {
      List<Prize> prizes = new ArrayList<>();
      // TODO
      return new ResponseEntity<>(prizes, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }


}
