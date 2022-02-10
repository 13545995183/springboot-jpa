package com.example.springbootthymeleaf.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Department {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private Integer number;

    @Column
    private String name;

    @OneToMany(cascade ={CascadeType.PERSIST},mappedBy = "dep")
    private List<Employee> emps;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }
}
