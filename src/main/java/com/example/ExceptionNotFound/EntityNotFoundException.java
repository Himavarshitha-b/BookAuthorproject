package com.example.ExceptionNotFound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


	@SuppressWarnings("serial")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class EntityNotFoundException extends RuntimeException {
	    public EntityNotFoundException(Long id) {
	        super("BookAuthor not found with id: " + id);
	    }
	}


