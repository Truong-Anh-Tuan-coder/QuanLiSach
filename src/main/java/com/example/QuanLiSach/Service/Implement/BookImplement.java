package com.example.QuanLiSach.Service.Implement;

import com.example.QuanLiSach.Entity.BookEntity;
import com.example.QuanLiSach.Respository.BookRepository;
import com.example.QuanLiSach.Service.BookService;

import java.awt.print.Book;
import java.util.ArrayList;

public class BookImplement implements BookService {
	private BookRepository repository = new BookRepository();

	@Override
	public BookEntity findByID(int id) {
		return this.repository.findByID(id);
	}

	@Override
	public BookEntity findBookName(String bookName) {
		return this.repository.findByName(bookName);
	}

	@Override
	public ArrayList<BookEntity> findAllByImportedDate(String date) {
		return this.repository.findAllByImportedDate(date);
	}

	@Override
	public ArrayList<BookEntity> findTop5BestSeller() {
		return this.repository.findTop5BestSeller();
	}

	@Override
	public ArrayList<BookEntity> findAll() {
		return this.repository.findAll();
	}

	@Override
	public void create(BookEntity bookEntity) {
		this.repository.create(bookEntity);
	}

	@Override
	public void update(BookEntity bookEntity) {
		this.repository.update(bookEntity);
	}

	@Override
	public void remove(BookEntity bookEntity) {
		this.repository.remove(bookEntity);
	}
}
