package com.safra.safrat6.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.safra.safrat6.model.Prize;
import com.safra.safrat6.service.PrizeService;


@RestController
@RequestMapping("/prizes")
public class PrizeController {

  @Autowired
  private PrizeService prizeService;

  @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<Object> postPrize(@Validated @ModelAttribute Prize prize) {
    try {
      prize = prizeService.postPrize(prize);
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
