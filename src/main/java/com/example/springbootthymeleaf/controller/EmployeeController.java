package com.example.springbootthymeleaf.controller;

import com.example.springbootthymeleaf.Dao.EmployeeDao;
import com.example.springbootthymeleaf.entity.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("emplController")
@Api(value="Employee Controller" ,tags="员工接口")
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @ApiOperation(value="查询所有员工",notes="查询所有员工")
    @GetMapping
    public List<Employee> find(){
        List<Employee> list=employeeDao.findAll();
        return list;
    }
    @PostMapping
    public boolean add(Employee e){
        Employee employee= employeeDao.save(e);
        if (employee.getId()!=null){
            return true;
        }
        return false;
    }
    @PutMapping
    public boolean update(Employee employee){
        Employee e= employeeDao.save(employee);
        if (e.getId()!=null){
            return true;
        }
        return false;
    }
    //@PathVariable是在url中获取url中的参数
    @DeleteMapping
    public void delete(@PathVariable Integer id){
        employeeDao.deleteById(id);
    }
    @GetMapping("{id}")
    @ApiOperation(value="find one  Employee" ,notes = "查询单个员工")
    public Employee finOne(@ApiParam(name="员工id",value="id",required = true)
                           @PathVariable Integer id){
        Optional<Employee> e=employeeDao.findById(id);
        return e.get();
    }
    @PostMapping("update")
    @ApiOperation(value="save one  Employee" ,notes = "保存单个员工")
    @ApiImplicitParam(dataType = "com.example.springbootthymeleaf.entity.Employee")
    public void updateOne(@RequestBody Employee employee){
        employeeDao.save(employee);
    }
}
