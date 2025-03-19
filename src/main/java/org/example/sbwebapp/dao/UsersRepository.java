package org.example.sbwebapp.dao;

import org.example.sbwebapp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface UsersRepository extends JpaRepository<User, Integer> {

}
