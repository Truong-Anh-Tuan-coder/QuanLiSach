package com.example.QuanLiSach.Respository;

import ch.qos.logback.classic.joran.sanity.IfNestedWithinSecondPhaseElementSC;
import com.example.QuanLiSach.Connection.DBconnection;
import com.example.QuanLiSach.Entity.BookEntity;

import java.awt.print.Book;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookRepository {
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private DBconnection dBconnection = new DBconnection();

	//common
	private BookEntity book = null;
	private ArrayList<BookEntity> books = null;
	private StringBuilder SQLquery;

	// constructors
	public BookRepository() {
	}
	// get book by id
	public BookEntity findByID(int id) {
		book = null;
		SQLquery = null;

		try {
			SQLquery = new StringBuilder();

			SQLquery.append("Select * from Book ");
			SQLquery.append("where Book_ID = " + id);

			dBconnection.openConnect();
			this.preparedStatement = this.dBconnection.getConnection().prepareStatement(SQLquery.toString());
			resultSet = this.preparedStatement.executeQuery();

			if (resultSet.isBeforeFirst()) {
				book = new BookEntity();

				while (this.resultSet.next()) {
					book.setId(this.resultSet.getInt("Book_ID"));
					book.setName(this.resultSet.getString("Book_name"));
					book.setQuantity(this.resultSet.getInt("Quantity"));
					book.setImporteDate(this.resultSet.getString("Imported_Date"));
				}
				return book;
			} else {
				System.out.println("not found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (this.dBconnection != null) {
					this.dBconnection.closeConnection();
				}
				if (this.preparedStatement != null) {
					this.preparedStatement.close();
				}
				if (this.resultSet != null) {
					this.resultSet.close();
				}
			} catch (SQLException e) {
				System.out.println("Something wrong during close connections");
			}
		}
		System.out.println("Something wrong on get book by id");
		return null;
	}

	// get book by name
	public BookEntity findByName(String name) {
		book = null;
		SQLquery = null;

		try {
			SQLquery = new StringBuilder();

			SQLquery.append("Select * from Book ");
			SQLquery.append("where Book_name = " + name);

			dBconnection.openConnect();
			this.preparedStatement = this.dBconnection.getConnection().prepareStatement(SQLquery.toString());
			resultSet = this.preparedStatement.executeQuery();

			if (resultSet.isBeforeFirst()) {
				book = new BookEntity();

				while (this.resultSet.next()) {
					book.setId(this.resultSet.getInt("Book_ID"));
					book.setName(this.resultSet.getString("Book_name"));
					book.setQuantity(this.resultSet.getInt("Quantity"));
					book.setImporteDate(this.resultSet.getString("Imported_Date"));
				}
				return book;
			} else {
				System.out.println("not found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (this.dBconnection != null) {
					this.dBconnection.closeConnection();
				}
				if (this.preparedStatement != null) {
					this.preparedStatement.close();
				}
				if (this.resultSet != null) {
					this.resultSet.close();
				}
			} catch (SQLException e) {
				System.out.println("Something wrong during close connections");
			}
		}
		System.out.println("Something wrong on get book by name");
		return null;
	}

	// get all books by imported date
	public ArrayList<BookEntity> findAllByImportedDate(String date) {
		this.book = null;
		this.books = null;
		this.SQLquery = null;

		try {
			SQLquery = new StringBuilder();

			SQLquery.append("Select * from Book ");
			SQLquery.append("where Imported_Date = " + date);


			dBconnection.openConnect();
			this.preparedStatement = this.dBconnection.getConnection().prepareStatement(SQLquery.toString());
			resultSet = this.preparedStatement.executeQuery();

			if (resultSet.isBeforeFirst()) {
				book = new BookEntity();
				books = new ArrayList<BookEntity>();

				while (this.resultSet.next()) {
					book.setId(this.resultSet.getInt("Book_ID"));
					book.setName(this.resultSet.getString("Book_name"));
					book.setQuantity(this.resultSet.getInt("Quantity"));
					book.setImporteDate(this.resultSet.getString("Imported_Date"));
					books.add(book);
				}
				return books;
			} else {
				System.out.println("not found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (this.dBconnection != null) {
					this.dBconnection.closeConnection();
				}
				if (this.preparedStatement != null) {
					this.preparedStatement.close();
				}
				if (this.resultSet != null) {
					this.resultSet.close();
				}
			} catch (SQLException e) {
				System.out.println("Something wrong during close connections");
			}
		}
		System.out.println("Something wrong on get all books");
		return null;
	}

	// get all books
	public ArrayList<BookEntity> findAll() {
		this.book = null;
		this.books = null;
		this.SQLquery = null;

		try {
			SQLquery = new StringBuilder();

			SQLquery.append("Select * from Book ");

			dBconnection.openConnect();
			this.preparedStatement = this.dBconnection.getConnection().prepareStatement(SQLquery.toString());
			resultSet = this.preparedStatement.executeQuery();

			if (resultSet.isBeforeFirst()) {
				book = new BookEntity();
				books = new ArrayList<BookEntity>();

				while (this.resultSet.next()) {
					book.setId(this.resultSet.getInt("Book_ID"));
					book.setName(this.resultSet.getString("Book_name"));
					book.setQuantity(this.resultSet.getInt("Quantity"));
					book.setImporteDate(this.resultSet.getString("Imported_Date"));
					books.add(book);
				}
				return books;
			} else {
				System.out.println("not found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (this.dBconnection != null) {
					this.dBconnection.closeConnection();
				}
				if (this.preparedStatement != null) {
					this.preparedStatement.close();
				}
				if (this.resultSet != null) {
					this.resultSet.close();
				}
			} catch (SQLException e) {
				System.out.println("Something wrong during close connections");
			}
		}
		System.out.println("Something wrong on get all books");
		return null;
	}

	// get top 5 best seller
	public ArrayList<BookEntity> findTop5BestSeller() {
		this.book = null;
		this.books = null;
		this.SQLquery = null;

		try {
			SQLquery = new StringBuilder();

			SQLquery.append("SELECT a.Book_name, COUNT(b.Book_ID) AS total_sale \n" +
					"FROM book a \n" +
					"JOIN Saled_Book b ON a.Book_ID = b.Book_ID \n" +
					"GROUP BY a.Book_name \n" +
					"order by total_Sale DESC \n" +
					"fetch first 5 rows only;");

			dBconnection.openConnect();
			this.preparedStatement = this.dBconnection.getConnection().prepareStatement(SQLquery.toString());
			resultSet = this.preparedStatement.executeQuery();

			if (resultSet.isBeforeFirst()) {
				book = new BookEntity();
				books = new ArrayList<BookEntity>();
				int index = 0 ;
				while (this.resultSet.next()) {
					index++;
					book.setName(this.resultSet.getString("Book_name"));
					book.setTotalSale(this.resultSet.getInt("total_sale"));
					books.add(book);
				}
				return books;
			} else {
				System.out.println("not found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (this.dBconnection != null) {
					this.dBconnection.closeConnection();
				}
				if (this.preparedStatement != null) {
					this.preparedStatement.close();
				}
				if (this.resultSet != null) {
					this.resultSet.close();
				}
			} catch (SQLException e) {
				System.out.println("Something wrong during close connections");
			}
		}
		System.out.println("Something wrong on get all books");
		return null;
	}

	// import new book
	public void create(BookEntity bookEntity){
		SQLquery = null;

		try {
			SQLquery = new StringBuilder();

			SQLquery.append("insert into Book(Book_name, Quantity, Imported_Date ");
			SQLquery.append("values ('" + bookEntity.getName() + "') , ('" + bookEntity.getQuantity() + "'), ('" + bookEntity.getName() + "')");

			dBconnection.openConnect();
			this.preparedStatement = this.dBconnection.getConnection().prepareStatement(SQLquery.toString());
			resultSet = this.preparedStatement.executeQuery();
			System.out.println("Book Added");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (this.dBconnection != null) {
					this.dBconnection.closeConnection();
				}
				if (this.preparedStatement != null) {
					this.preparedStatement.close();
				}
				if (this.resultSet != null) {
					this.resultSet.close();
				}
			} catch (SQLException e) {
				System.out.println("Something wrong during close connections");
			}
		}
	}

	//update book by id
	public void update(BookEntity bookEntity){
		SQLquery = null;

		try {
			SQLquery = new StringBuilder();

			SQLquery.append("update Book " );
			SQLquery.append("set Book_name = '" + bookEntity.getName() + "' , Quantity = '" + bookEntity.getQuantity() + "' , " +
					"Imported_Date = '" + bookEntity.getImporteDate() + "'  ");
			SQLquery.append("where Book_ID = " + bookEntity.getId() + " ");

			dBconnection.openConnect();
			this.preparedStatement = this.dBconnection.getConnection().prepareStatement(SQLquery.toString());
			resultSet = this.preparedStatement.executeQuery();
			System.out.println("Book updated");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (this.dBconnection != null) {
					this.dBconnection.closeConnection();
				}
				if (this.preparedStatement != null) {
					this.preparedStatement.close();
				}
				if (this.resultSet != null) {
					this.resultSet.close();
				}
			} catch (SQLException e) {
				System.out.println("Something wrong during close connections");
			}
		}
	}

	//delete book by id
	public void  remove(BookEntity bookEntity) {
		SQLquery = null;

		try {
			SQLquery = new StringBuilder();

			SQLquery.append("delete from Book " );
			SQLquery.append("where Book_ID = " + bookEntity.getId() + " ");

			dBconnection.openConnect();
			this.preparedStatement = this.dBconnection.getConnection().prepareStatement(SQLquery.toString());
			resultSet = this.preparedStatement.executeQuery();
			System.out.println("Book deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (this.dBconnection != null) {
					this.dBconnection.closeConnection();
				}
				if (this.preparedStatement != null) {
					this.preparedStatement.close();
				}
				if (this.resultSet != null) {
					this.resultSet.close();
				}
			} catch (SQLException e) {
				System.out.println("Something wrong during close connections");
			}
		}
	}
}

