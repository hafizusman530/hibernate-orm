package com.usman.practice.hibernate;

import com.usman.practice.hibernate.entity.Employee;
import com.usman.practice.hibernate.repository.EmployeeRepository;
import com.usman.practice.hibernate.repository.Repository;
import com.usman.practice.hibernate.util.HibernateUtil;

public class App {
    public static void main(String[] args) {
        Repository<Employee> employeeRepository = new EmployeeRepository();
        Employee employee = new Employee("Muhammad", "Usman", "usmandev",
                "12345", "03217995855", "SKP", "employee");
        String id = employeeRepository.add(employee);
        System.out.println("New Employee add with ID " + id);
        employeeRepository.delete("usmandev");
        employeeRepository.getList().forEach(emp -> System.out.println(emp.toString()));
        System.out.println(employeeRepository.get("admin").toString());
        Employee employee1 = new Employee("2","Muhammd", "Usman", "user",
                "12dea96fec20593566ab75692c9949596833adc9", "123456789", "Lahore", "user");
//        employeeRepository.update(employee1);
        HibernateUtil.shutDown();
    }

}
