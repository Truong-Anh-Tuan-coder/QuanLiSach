package com.example.QuanLiSach.Controller;

import com.example.QuanLiSach.Entity.BookEntity;
import com.example.QuanLiSach.Service.BookService;
import com.example.QuanLiSach.Service.Implement.BookImplement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BookController {
	private BookEntity bookEntity;
	private ArrayList<BookEntity> bookEntities;
	private BookService bookService = new BookImplement();
	private int choice;
	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;

	public void findByID () throws IOException {
		bookEntity = new BookEntity();
		System.out.print("input book id: ");
		bookEntity.setId(Integer.parseInt(in.readLine()));
		bookEntity = bookService.findByID(bookEntity.getId());
		System.out.println(bookEntity.getId() +" " + bookEntity.getName() + " " + bookEntity.getQuantity());
	}
	public void findByID (int id) throws IOException {
		bookEntity = bookService.findByID(id);
		System.out.print(bookEntity.getId() +" " + bookEntity.getName() + " " + bookEntity.getQuantity() + " " + bookEntity.getImporteDate());
	}
	public void findByName () throws IOException {
		bookEntity = new BookEntity();
		System.out.print("input book id: ");
		bookEntity.setName(in.readLine());
		bookEntity = bookService.findBookName(bookEntity.getName());
		System.out.print(bookEntity.getId() +" " + bookEntity.getName() + " " + bookEntity.getQuantity());
	}
	public void findAllByImportedDate () throws IOException {
		bookEntity = new BookEntity();
		bookEntities = new ArrayList<>();

		System.out.print("input book id: ");
		bookEntity.setImporteDate(in.readLine());
		bookEntities = bookService.findAllByImportedDate(bookEntity.getName());
		for(BookEntity item : bookEntities){
			System.out.print(item.getId() +" " + item.getName() + " " + item.getQuantity() + " "+ item.getImporteDate());
		}
	}
	public void findAll (){
		bookEntities = new ArrayList<>();

		bookEntities = bookService.findAll();
		for(BookEntity item : bookEntities){
			System.out.print(item.getId() +" " + item.getName() + " " + item.getQuantity() + " "+ item.getImporteDate());
		}

	}
	public void findTop5BestSeller (){
		bookEntities = new ArrayList<>();
		bookEntities = bookService.findAll();
		for(BookEntity item : bookEntities){
			System.out.print(item.getId() +" " + item.getName() + " " + item.getQuantity() + " "+ item.getImporteDate());
		}
	}
	public void create () throws IOException {
		bookEntity = new BookEntity();
		System.out.print("input new book name: ");
		bookEntity.setName(in.readLine());
		System.out.print("input quantity: ");
		bookEntity.setQuantity(Integer.parseInt(in.readLine()));
		System.out.print("input imported day: ");
		bookEntity.setImporteDate(in.readLine());
		bookService.create(bookEntity);
	}
	public void update () throws IOException {
		bookEntity = new BookEntity();

		System.out.print("input book id you want update: ");
		findByID(Integer.parseInt(in.readLine()));
		System.out.print("input rename book : ");
		bookEntity.setName(in.readLine());
		System.out.print("re input quantity: ");
		bookEntity.setQuantity(Integer.parseInt(in.readLine()));
		System.out.print("re input imported day: ");
		bookEntity.setImporteDate(in.readLine());
		bookService.update(bookEntity);
	}
	public void remove () throws IOException {
		bookEntity = new BookEntity();

		System.out.print("input book id to remove: ");
		bookEntity.setId(Integer.parseInt(in.readLine()));
		bookService.remove(bookEntity);
	}

}
