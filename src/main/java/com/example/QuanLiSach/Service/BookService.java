package com.example.QuanLiSach.Service;

import com.example.QuanLiSach.Entity.BookEntity;

import java.util.ArrayList;

public interface BookService extends BaseService <BookEntity> {
	BookEntity findByID (int id);
	BookEntity findBookName(String bookName);
	ArrayList<BookEntity> findAllByImportedDate (String Date);
	ArrayList<BookEntity> findTop5BestSeller();
}
