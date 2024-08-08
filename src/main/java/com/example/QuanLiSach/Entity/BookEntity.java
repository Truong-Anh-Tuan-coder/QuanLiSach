package com.example.QuanLiSach.Entity;

public class BookEntity extends BaseEntity{
	private String name;
	private String importeDate;
	private int totalSale;

	//getters setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImporteDate() {
		return importeDate;
	}

	public void setImporteDate(String importeDate) {
		this.importeDate = importeDate;
	}

	public int getTotalSale() {
		return totalSale;
	}

	public void setTotalSale(int totalSale) {
		this.totalSale = totalSale;
	}
}
