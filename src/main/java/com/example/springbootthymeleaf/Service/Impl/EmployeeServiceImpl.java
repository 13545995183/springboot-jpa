package com.example.springbootthymeleaf.Service.Impl;

import com.example.springbootthymeleaf.Dao.EmployeeDao;
import com.example.springbootthymeleaf.Dao.RedisEmployeeDao;
import com.example.springbootthymeleaf.Service.EmployeeService;
import com.example.springbootthymeleaf.entity.EmployeeRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeDao dao;

    @Autowired
    RedisEmployeeDao redisEmployeeDao;
    //key为条件查询
    @Cacheable(value="employee",key="(#condition.number!=null?#condition.number!='')+" +
            "(#condition.name!=null?#condition.name!='')+(#condition.gender!=null?#condition.gender!='')+"+
            "(#condition.age!=null?#condition.age!='')")
    public List<EmployeeRedis> searchData(EmployeeRedis condition){
        List<EmployeeRedis> employeeRedis=redisEmployeeDao.searchData(condition);
        return employeeRedis;
    }
    @CachePut(value="employee",key="#emp.gender")
    public EmployeeRedis add(EmployeeRedis emp){
        EmployeeRedis employeeRedis=redisEmployeeDao.save(emp);
        return employeeRedis;
    }
    @Cacheable(value="employee",key="#id")
    public EmployeeRedis searchOne(Integer id){
        Optional<EmployeeRedis> e=redisEmployeeDao.findById(id);
        return e.get();
    }
    @CachePut(value="employee",key="#emp.name")
    public EmployeeRedis update(EmployeeRedis emp){
        Optional<EmployeeRedis> employeeRedis=redisEmployeeDao.findById(emp.getId());
        employeeRedis.get().setName(emp.getName());
        return redisEmployeeDao.save(emp);
    }
    @CacheEvict(value="employee",key="#id")
    public void delete(Integer id){
        Optional<EmployeeRedis> employeeRedis=redisEmployeeDao.findById(id);
        redisEmployeeDao.delete(employeeRedis.get());
    }

}
