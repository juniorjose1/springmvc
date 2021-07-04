package br.com.alexandre.springmvcwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alexandre.springmvcwebapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	public User findByUsername(String name);

}
