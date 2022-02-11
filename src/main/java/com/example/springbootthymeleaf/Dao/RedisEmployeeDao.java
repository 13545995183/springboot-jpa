package com.example.springbootthymeleaf.Dao;

import com.example.springbootthymeleaf.entity.EmployeeRedis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface RedisEmployeeDao extends CrudRepository<EmployeeRedis, Integer> {
    Iterable<EmployeeRedis> findByName(String name) ;
}
