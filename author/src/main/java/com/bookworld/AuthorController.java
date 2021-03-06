package com.bookworld;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookworld.domain.Author;
import com.bookworld.service.AuthorService;

@RestController
public class AuthorController {

	private final AuthorService authorService;

	@Autowired
	public AuthorController(final AuthorService authorService) {
		this.authorService = authorService;
	}

	@RequestMapping(value = "/authors", method = RequestMethod.GET)
	public ResponseEntity<Collection<Author>> getAuthors() {
		return new ResponseEntity<Collection<Author>>(authorService.getAuthors(), HttpStatus.OK);
	}

	@RequestMapping(value = "/authors", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> create(@RequestBody Author author) {
		authorService.create(author);
		return new ResponseEntity<String>("Author created successfully", HttpStatus.OK);
	}

}
