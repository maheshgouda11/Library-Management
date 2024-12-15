package com.Library.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Library.restapi.entity.Book;

public interface Bookrepository extends JpaRepository<Book,Integer>{

}
