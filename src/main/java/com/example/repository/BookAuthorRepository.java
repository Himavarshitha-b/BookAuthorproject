package com.example.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.entity.BookAuthor;

@Repository
	public interface BookAuthorRepository extends JpaRepository<BookAuthor,Long> {

	List<BookAuthor> findAllByOrderByIdDesc();

//		Optional<BookAuthor> updateById(Long id);

		/*
		 * public BookAuthor save(BookAuthor bookAuthor) { // TODO Auto-generated method
		 * stub return null; }
		 * 
		 * public Optional<BookAuthor> findById(Long id) { // TODO Auto-generated method
		 * stub return null; }
		 * 
		 * public void delete(BookAuthor bookAuthor) { // TODO Auto-generated method
		 * stub
		 * 
		 * }
		 * 
		 * public List<BookAuthor> findAll() { // TODO Auto-generated method stub return
		 * null; }
		 */

	}



