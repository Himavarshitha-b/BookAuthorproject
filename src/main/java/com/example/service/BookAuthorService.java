package com.example.service;

import java.util.List;
import java.util.Map;

import com.example.entity.BookAuthor;

public interface BookAuthorService {

	BookAuthor addBookAuthor(BookAuthor bookAuthor);

	BookAuthor getBookAuthor(Long id);

	List<BookAuthor> getAllBookAuthors();

	BookAuthor updateBookAuthor(Long id, BookAuthor bookAuthor);

	void deleteBookAuthor(Long id);

	BookAuthor patchBookAuthor(Long id, Map<Object, Object> bookAuthor);

	void deleteAllBookAuthors();
	

}
