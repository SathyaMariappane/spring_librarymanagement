package com.example.library.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.library.entity.Library;
import com.example.library.repository.LibraryRepository;


@Controller
public class LibraryController {
	
	@Autowired	
	LibraryRepository repo;
	
	@RequestMapping("/saveBook")
	@ResponseBody
	public List<Library> add(@RequestParam int id, @RequestParam int quantity, @RequestParam String bookName, @RequestParam String genre)
	{
		Library lib = new Library();
		lib.setId(id);
		lib.setQuantity(quantity);
		lib.setBookName(bookName);
		lib.setGenre(genre);
		repo.save(lib);
		
		return repo.displayBook(id);
	}
	
	@RequestMapping("/editBook")
	@ResponseBody
	public List<Library> editbook(@RequestParam int id)
	{
		return repo.displayBook(id);
	}
	
	@RequestMapping("/deleteBook")
	@ResponseBody
	public List<Library> deletebook(@RequestParam int id) 
	{
	      repo.deleteById(id);
	      return repo.displayBook(id);
	}
	
	@RequestMapping("/getBooks")
	@ResponseBody
	public List<Library> getBooks()
	{
		return repo.findAll();
	}
	
	@RequestMapping("/getByType")
	@ResponseBody
	public List<Library> genre(@RequestParam String genre)
	{	
		return repo.getBookType(genre);
	}	

}
