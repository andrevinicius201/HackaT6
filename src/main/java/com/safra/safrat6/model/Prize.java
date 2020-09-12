package com.safra.safrat6.model;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Prize {

  private Long id;
  private String description;
  private String imageUrl;
  private BigDecimal value;
  private List<Sticker> stickers;
  private List<Account> accounts;
  private Integer rowsQuantity;
  private Integer columnsQuantity;
  private MultipartFile file;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public List<Sticker> getStickers() {
    return stickers;
  }

  public void setStickers(List<Sticker> stickers) {
    this.stickers = stickers;
  }

  public List<Account> getAccounts() {
    return accounts;
  }

  public void setAccounts(List<Account> accounts) {
    this.accounts = accounts;
  }

  public Integer getRowsQuantity() {
    return rowsQuantity;
  }

  public void setRowsQuantity(Integer rowsQuantity) {
    this.rowsQuantity = rowsQuantity;
  }

  public Integer getColumnsQuantity() {
    return columnsQuantity;
  }

  public void setColumnsQuantity(Integer columnsQuantity) {
    this.columnsQuantity = columnsQuantity;
  }

  public MultipartFile getFile() {
    return file;
  }

  public void setFile(MultipartFile file) {
    this.file = file;
  }

}
