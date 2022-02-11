package com.example.springbootthymeleaf.Test;

import com.example.springbootthymeleaf.Dao.RedisEmployeeDao;
import com.example.springbootthymeleaf.entity.EmployeeRedis;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

@RestController
@RequestMapping("redis")
public class RedisTest {
    @Autowired
    private RedisEmployeeDao employeeDao;

    @GetMapping("save")
    void setEmployee(){
        EmployeeRedis employeeRedis1=new EmployeeRedis();
        employeeRedis1.setAge(11);
        employeeRedis1.setName("俩啊");
        employeeRedis1.setNumber(1111);
        employeeRedis1.setGender("女");
        EmployeeRedis employeeRedis2=new EmployeeRedis();
        employeeRedis2.setAge(122);
        employeeRedis2.setName("hi米");
        employeeRedis2.setNumber(222);
        employeeRedis2.setGender("男");
        employeeDao.save(employeeRedis1);
        employeeDao.save(employeeRedis2);
    }
    @GetMapping("findAll")
    void getEmps(){
        Iterable<EmployeeRedis> iterable=employeeDao.findAll();
        Iterator<EmployeeRedis> iterator=iterable.iterator();
        while(iterator.hasNext()){
            EmployeeRedis e=iterator.next();
            System.out.println(e.getId()+"  "+e.getName()+"  "+e.getAge()+"  "+e.getGender());
        }
    }
}
