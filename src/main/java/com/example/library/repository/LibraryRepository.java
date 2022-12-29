package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.example.library.entity.Library;

public interface LibraryRepository extends JpaRepository<Library, Integer> {
	
	@Query(value = "SELECT * FROM Library WHERE id=?1", nativeQuery = true)
	List<Library> displayBook(int id);
	
	@Query(value = "DELETE FROM Library WHERE id=?1", nativeQuery = true)
	void deleteBook(int id);
	
	@Query(value = "SELECT * FROM Library WHERE genre=?1", nativeQuery = true)
	List<Library> getBookType(String genre);
	
	

}
