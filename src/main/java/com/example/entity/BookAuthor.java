package com.example.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book_authors")
public class BookAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    private String name;
    private LocalDate birthdate;
    private String nationality;
    private Integer yearOfPublication;
    private String bookName;

    private String yearOfPublicationInWords;
    
    public BookAuthor() {
        // Default constructor
    }
    public BookAuthor(Long id, String name, LocalDate birthdate, String nationality, Integer yearOfPublication, String bookName) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.nationality = nationality;
        this.yearOfPublication = yearOfPublication;
        this.bookName = bookName;
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long nextId) {
        this.id = nextId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getYearOfPublicationInWords() {
        return yearOfPublicationInWords;
    }

    public void setYearOfPublicationInWords(String yearOfPublicationInWords) {
        this.yearOfPublicationInWords = yearOfPublicationInWords;
    }
	
		
	}
