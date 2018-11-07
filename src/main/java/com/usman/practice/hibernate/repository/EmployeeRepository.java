package com.usman.practice.hibernate.repository;

import com.usman.practice.hibernate.entity.Employee;
import com.usman.practice.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeRepository implements Repository<Employee> {
    @Override
    public String add(Employee employee) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        String id = (String) session.save(employee);
        transaction.commit();
        return id;
    }

    @Override
    public List<Employee> getList() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        List<Employee> employeeList = session.createQuery("from Employee").list();
//        List<Employee> employeeList = session.createCriteria(Employee.class).list();
        transaction.commit();
        return employeeList;
    }

    @Override
    public boolean delete(String username) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        int status = session.createQuery("delete from Employee where username=:username")
                .setParameter("username", username)
                .executeUpdate();
        session.getTransaction().commit();
        return status == 1;
    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public Employee get(String id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Employee employee = session.cre
        session.getTransaction().commit();
        return employee;
    }
}
