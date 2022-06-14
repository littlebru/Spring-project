package com.springboot.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.springboot.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
	
	// Buscando os ids maiores que o id informado (Duas formas de fazer)
	// public List<User> findByIdGreaterThan(Long id);
	  @Query("SELECT u from User u where u.id > :id")
	  public List<User> findAllMoreThan(@Param("id") Long id);
	  
	  // Buscando usuario pelo nome
	  public List<User> findByNameIgnoreCase(String name);
	  
	  // Buscando Usuario pelo username
	  public List<User> findByUsername(String username);

	
	

}
