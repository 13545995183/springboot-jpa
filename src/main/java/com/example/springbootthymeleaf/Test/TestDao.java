package com.example.springbootthymeleaf.Test;

import com.example.springbootthymeleaf.Dao.DepartmentDao;
import com.example.springbootthymeleaf.Dao.EmployeeDao;
import com.example.springbootthymeleaf.entity.Department;
import com.example.springbootthymeleaf.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestDao {
    @Autowired
    private EmployeeDao dao;

    @Autowired
    private DepartmentDao depDao;

    @GetMapping("/findAll")
    public List<Employee> findAll(){
        List<Employee> employeeList=dao.findAll();
        for (int i = 0; i < employeeList.size(); i++) {
            System.out.println("id:"+employeeList.get(i).getId()+";name:"+employeeList.get(i).getName()
            +";age:"+employeeList.get(i).getAge());
        }
        return dao.findAll();
    }
    @GetMapping("/save")
    public void save(){
        Employee e=new Employee();
        e.setAge(20);
        e.setGender("男");
        e.setName("钱多多");
        e.setNumber(1111);
        Employee newe=dao.save(e);
        System.out.println(newe.getId());
    }
    @GetMapping("/find")
    public void  findone(){
        //Employee employee=dao.findByGender("女");
        //Employee employee=dao.findByQuery();
        List<Employee> list=dao.findAll();
        for (Employee employee: list) {
            System.out.println(employee.getName()+"  "+employee.getGender()+"   "+employee.getDep().getName());
        }


    }
    @GetMapping("/savedep")
    public void savedep(){
        Department department=new Department();
        department.setName("管理员");
        department.setNumber(1111);
        Department newDep=depDao.save(department);
        System.out.println(newDep.getId());
    }


    @GetMapping("/saveMany")
    public void saveMany(){
        List<Employee> list=new ArrayList<>();
        Department department=new Department();
        department.setName("质量部");
        Employee e1=new Employee();
        e1.setName("qdd123");
        e1.setNumber(1021);
        e1.setDep(department);
        Employee e2=new Employee();
        e2.setName("前端");
        e2.setNumber(1022);
        e2.setDep(department);
        list.add(e1);
        list.add(e2);
        department.setEmps(list);
        Department newDep=depDao.save(department);
        System.out.println(newDep.getId());
    }

}
