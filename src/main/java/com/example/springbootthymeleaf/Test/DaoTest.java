package com.example.springbootthymeleaf.Test;

import com.example.springbootthymeleaf.Dao.EmployeeDao;
import com.example.springbootthymeleaf.entity.Employee;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

import java.util.List;

@SpringBootTest
public class DaoTest {
    @Autowired
    private EmployeeDao dao;

    @Test
    public void testAll(){
        List<Employee> employeeList=dao.findAll();
        for (int i = 0; i < employeeList.size(); i++) {
            System.out.println(employeeList.get(i));
        }
    }
}
