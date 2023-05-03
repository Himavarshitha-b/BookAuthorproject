package com.example.serviceImpl;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import com.example.entity.BookAuthor;
import com.example.repository.BookAuthorRepository;
import com.example.service.BookAuthorService;
import com.example.stubs.NumberConversion;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BookAuthorServiceImpl implements BookAuthorService {

	@Autowired
	private BookAuthorRepository bookAuthorRepository;

	@Override
	@Transactional
	public BookAuthor addBookAuthor(BookAuthor bookAuthor) {
		
//		   CountryInfoService countryInfoService = new CountryInfoService();
//		    
//		    // Get the ISO code for India
//		    String indiaISOCode = countryInfoService.getCountryInfoServiceSoap().countryISOCode("India");
//		    
//		    // Set the nationality to India in the bookAuthor object
//		    bookAuthor.setNationality("India");
		
		bookAuthor.setYearOfPublicationInWords(new NumberConversion().getNumberConversionSoap().numberToWords(BigInteger.valueOf(bookAuthor.getYearOfPublication())));
		return bookAuthorRepository.save(bookAuthor);
	}

	@Override
	@Transactional(readOnly = true)
	public BookAuthor getBookAuthor(Long id) {
		return bookAuthorRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
	}

	@Override
	@Transactional(readOnly = true)
	public List<BookAuthor> getAllBookAuthors() {
//		return bookAuthorRepository.findAll();
		return bookAuthorRepository.findAllByOrderByIdDesc();

	}

	@Override
	@Transactional
	public BookAuthor updateBookAuthor(Long id, BookAuthor bookAuthor) {
		BookAuthor existingBookAuthor = bookAuthorRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("BookAuthor not found with id: " + id));
		existingBookAuthor.setName(bookAuthor.getName());
		existingBookAuthor.setYearOfPublication(bookAuthor.getYearOfPublication());
		existingBookAuthor.setBookName(bookAuthor.getBookName());
		existingBookAuthor.setBirthdate(bookAuthor.getBirthdate());
		existingBookAuthor.setNationality(bookAuthor.getNationality());
		existingBookAuthor.setYearOfPublicationInWords(new NumberConversion().getNumberConversionSoap().numberToWords(BigInteger.valueOf(bookAuthor.getYearOfPublication())));

		// set any other fields you want to update
		return bookAuthorRepository.save(existingBookAuthor);
	}

	@Override
	@Transactional
	public void deleteBookAuthor(Long id) {
		bookAuthorRepository.deleteById(id);
	}

//    @Override
//    @Transactional
//    public BookAuthor patchBookAuthor(Long id, BookAuthor bookAuthor) {
//        BookAuthor existingBookAuthor = bookAuthorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("BookAuthor not found with id: " + id));
//        existingBookAuthor.setName(bookAuthor.getName());
//            existingBookAuthor.setName(bookAuthor.getName());
//            existingBookAuthor.setYearOfPublication(bookAuthor.getYearOfPublication());
//            existingBookAuthor.setBookName(bookAuthor.getBookName());
//            existingBookAuthor.setBirthdate(bookAuthor.getBirthdate());
//            existingBookAuthor.setNationality(bookAuthor.getNationality());
//        
//       
//        
//        // patch any other fields you want to update
//        return bookAuthorRepository.save(existingBookAuthor);
//    }

	@Override
	public void deleteAllBookAuthors() {
		bookAuthorRepository.deleteAll();
	}

	@Override
	public BookAuthor patchBookAuthor(Long id, Map<Object, Object> bookAuthor) {
		// TODO Auto-generated method stub
		BookAuthor model = bookAuthorRepository.findById(id).get();
		bookAuthor.forEach((key, value) -> {
			 Field field = ReflectionUtils.findField(BookAuthor.class, (String) key);
			field.setAccessible(true);
			ReflectionUtils.setField(field, model, value);
		});

		return bookAuthorRepository.save(model);
	}

}
