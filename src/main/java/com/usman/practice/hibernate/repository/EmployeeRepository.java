package com.usman.practice.hibernate.repository;

import com.usman.practice.hibernate.entity.Employee;
import com.usman.practice.hibernate.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(employee);
        session.getTransaction().commit();
    }

    @Override
    public Employee get(String username) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria sessionCriteria = session.createCriteria(Employee.class);
        sessionCriteria.add(Restrictions.eq("userName", username));
        List employee = sessionCriteria.list();
        session.getTransaction().commit();
        return (Employee) employee.get(0);
    }
}
