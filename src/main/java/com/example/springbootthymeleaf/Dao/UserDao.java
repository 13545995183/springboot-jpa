package com.example.springbootthymeleaf.Dao;

import com.example.springbootthymeleaf.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

public interface UserDao extends JpaRepository<user,Integer> {
}
