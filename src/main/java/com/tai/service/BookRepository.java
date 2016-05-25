package com.tai.service;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tai.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	
	List<Book> findByBookName(String bookName);
	
	List<Book> findByBookPrice(BigDecimal bookPrice);
	
	@Transactional
	Long deleteByBookName(String bookName); 
}
