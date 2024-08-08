package com.example.QuanLiSach.Entity;

public class SaledBookEntity {
	private BookEntity bookEntity;
	private String SaledDate;

	//getters setters
	public String getSaledDate() {
		return SaledDate;
	}

	public void setSaledDate(String saledDate) {
		SaledDate = saledDate;
	}

	public BookEntity getBookEntity() {
		return bookEntity;
	}

	public void setBookEntity(BookEntity bookEntity) {
		this.bookEntity = bookEntity;
	}
}
