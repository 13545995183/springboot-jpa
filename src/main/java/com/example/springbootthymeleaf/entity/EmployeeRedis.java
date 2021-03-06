package com.example.springbootthymeleaf.entity;

import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;

@RedisHash(value="employee")
public class EmployeeRedis {
    @Id
    private Integer id;

    @Column
    private Integer number;

    @Column
    private String name;

    @Column
    private String gender;

    @Column
    @Transient
    private Integer age;

    @ManyToOne
    @JoinColumn
    private Department dep;

    public Department getDep() {
        return dep;
    }

    public void setDep(Department dep) {
        this.dep = dep;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
