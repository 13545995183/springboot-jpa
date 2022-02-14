package com.example.springbootthymeleaf.Dao;

import com.example.springbootthymeleaf.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {

    Employee findByGender(String gender);

    //void updateOne(Employee );
}
