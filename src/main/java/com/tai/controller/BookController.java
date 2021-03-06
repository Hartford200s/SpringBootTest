package com.tai.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tai.model.Book;
import com.tai.model.Student;
import com.tai.service.BookRepository;

@RestController
public class BookController {
	
	@Autowired
	private BookRepository bookRespositroy;
	
	@RequestMapping("/getBook/{id}")
	public ResponseEntity<Book> queryBook(@PathVariable Long id) {
		Book book = bookRespositroy.findOne(id);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	
	@RequestMapping("/getBookByName/{name}")
	public ResponseEntity<List<Book>> getBookByName(@PathVariable String name) {
		List<Book> bookList = bookRespositroy.findByBookName(name);
		return new ResponseEntity<List<Book>>(bookList, HttpStatus.OK);
	}
	
	@RequestMapping("/getBookPrice/{bookPrice}")
	public ResponseEntity<List<Book>> getBookPrice(@PathVariable BigDecimal bookPrice) {
		List<Book> bookList = bookRespositroy.findByBookPrice(bookPrice);
		return new ResponseEntity<List<Book>>(bookList, HttpStatus.OK);
	}
	
	@RequestMapping("/deleteByBookName/{name}")
	public ResponseEntity<Long> deleteByBookName(@PathVariable String name) {
		Long delCount = bookRespositroy.deleteByBookName(name);
		return new ResponseEntity<Long>(delCount, HttpStatus.OK);
	}
	/**
	 * {
		"bookName": "TaiTestBook",
		"bookPrice": 100,
		"bookImage": "test123.img"
		}
	 * @param book
	 * @return
	 */
	@RequestMapping(path="/book", method=RequestMethod.POST)
	public ResponseEntity<Book> book(@RequestBody Book book) {
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	
	@RequestMapping(path="/saveBook", method=RequestMethod.POST)
	public ResponseEntity<Book> saveBook(@RequestBody Book book) {
		bookRespositroy.save(book);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	
	@RequestMapping(path="/updateBook/{id}", method=RequestMethod.POST)
	public ResponseEntity<Book> saveBook(@RequestBody Book book, @PathVariable Long id) {
		Book dbBook = bookRespositroy.findOne(id);
		dbBook.setBookName(book.getBookName());
		dbBook.setBookPrice(book.getBookPrice());
		dbBook.setBookImage(book.getBookImage());
		bookRespositroy.save(dbBook);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	
	@RequestMapping(path="/student", method=RequestMethod.POST)
	public ResponseEntity<Student> student(@RequestBody Student student) {
		System.out.println("student"+student);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
}
