package com.example.demo.service;

import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees ();
    boolean addEmployee(Employee employee);
    Employee getEmployeeById (String employeeId);
}
