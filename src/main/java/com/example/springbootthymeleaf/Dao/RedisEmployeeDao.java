package com.example.springbootthymeleaf.Dao;

import com.example.springbootthymeleaf.entity.Employee;
import com.example.springbootthymeleaf.entity.EmployeeRedis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface RedisEmployeeDao extends CrudRepository<EmployeeRedis, Integer> {
    default List<EmployeeRedis> searchData(EmployeeRedis condition) {
        return null;
    }

    Iterable<EmployeeRedis> findByName(String name) ;
}
