package com.example.springbootthymeleaf.Dao;

import com.example.springbootthymeleaf.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDao extends JpaRepository<Department,Integer> {
}
