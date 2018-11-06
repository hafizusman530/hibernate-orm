package com.usman.practice.hibernate;

import com.usman.practice.hibernate.entity.Employee;
import com.usman.practice.hibernate.repository.EmployeeService;
import com.usman.practice.hibernate.service.EmployeeServiceImp;

public class App {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeServiceImp();
        Employee employee = new Employee("Muhammad", "Usman", "usmandev",
                "12345", "03217995855", "SKP", "employee");
        employeeService.add(employee);
        employeeService.get().forEach(emp -> System.out.println(emp.toString()));
    }

}
