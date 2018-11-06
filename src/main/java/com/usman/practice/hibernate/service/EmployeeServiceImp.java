package com.usman.practice.hibernate.service;

import com.usman.practice.hibernate.entity.Employee;
import com.usman.practice.hibernate.repository.EmployeeService;
import com.usman.practice.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeServiceImp implements EmployeeService {
    public void add(Employee employee) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
    }

    public List<Employee> get() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        List<Employee> employeeList = session.createQuery("from Employee").list();
//        List<Employee> employeeList = session.createCriteria(Employee.class).list();
        transaction.commit();
        return employeeList;
    }

    public boolean delete(String id) {
        return false;
    }

    public void update(Employee employee) {

    }
}
