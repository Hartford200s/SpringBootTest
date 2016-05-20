package com.tai.controller;

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
	
	@RequestMapping(path="/book", method=RequestMethod.POST)
	public ResponseEntity<Book> book(@RequestBody Book book) {
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	
	@RequestMapping(path="/getStudent")
	public ResponseEntity<Student> getStudent() {
		Student s  = new Student("Tai",30);
		return new ResponseEntity<Student>(s, HttpStatus.OK);
	}
	
	@RequestMapping(path="/student", method=RequestMethod.POST)
	public ResponseEntity<Student> student(@RequestBody Student student) {
		System.out.println("student"+student);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
}
