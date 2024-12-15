package com.Library.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Library.restapi.entity.User;

public interface userrepository extends JpaRepository<User,Integer>{

}
