package com.safra.safrat6.model;

public class Sticker {
	
	private Integer prizeId;
	private Integer accountHolderId;
	private String urlImage;
	private int rowsQuantity;
	private int columnsQuantity;
	private int piece;
	

	public Integer getPrizeId() {
		return prizeId;
	}
	public void setPrizeId(Integer prizeId) {
		this.prizeId = prizeId;
	}
	public Integer getAccountHolderId() {
		return accountHolderId;
	}
	public void setAccountHolderId(Integer accountHolderId) {
		this.accountHolderId = accountHolderId;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public int getRowsQuantity() {
		return rowsQuantity;
	}
	public void setRowsQuantity(int rowsQuantity) {
		this.rowsQuantity = rowsQuantity;
	}
	public int getColumnsQuantity() {
		return columnsQuantity;
	}
	public void setColumnsQuantity(int columnsQuantity) {
		this.columnsQuantity = columnsQuantity;
	}
	public int getPiece() {
		return piece;
	}
	public void setPiece(int piece) {
		this.piece = piece;
	}
	
	

}
