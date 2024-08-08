package com.example.QuanLiSach;

import com.example.QuanLiSach.Controller.BookController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;

@SpringBootApplication
public class QuanLiSachApplication {

	public static void main(String[] args) throws IOException {
//		SpringApplication.run(QuanLiSachApplication.class, args);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BookController bookController = new BookController();
		int choice;
		do {
			menu();
			choice = Integer.parseInt(in.readLine());
			switch (choice){
				case 1: bookController.findByID(); break;
				case 2: bookController.findByName(); break;
				case 3: bookController.findAllByImportedDate(); break;
				case 4: bookController.findTop5BestSeller(); break;
				case 5: bookController.create(); break;
				case 6: bookController.update(); break;
				case 7: bookController.remove(); break;
				case 8: System.exit(0);
				default:
					System.out.println("invalid input");
					choice = -1;
					break;
			}
		} while ( choice != 8);

	}
	static void menu(){
		System.out.println("1. findByID");
		System.out.println("2. findByName");
		System.out.println("3. findAllByImportedDate");
		System.out.println("4. findTop5BestSeller");
		System.out.println("5. create book by id");
		System.out.println("6. update book by id");
		System.out.println("7. remove book by id");
		System.out.println("8. exit");
		System.out.print("Input your choice: ");
	}

}
