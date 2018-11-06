package com.usman.practice.hibernate.repository;

import com.usman.practice.hibernate.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void add(Employee employee);
    List<Employee> get();
    boolean delete(String id);
    void update(Employee employee);
}
