package com.codeuser.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeuser.service.Entities.User;

public interface UserRepository extends JpaRepository<User, String> {

	//custom queries
}
