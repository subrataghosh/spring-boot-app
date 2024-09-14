package com.example.demo.service.impl;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getAllEmployees() {
        List<com.example.demo.entity.Employee> entities = employeeDao.findAll();

        return entities.stream()
                .map(this::convertToModel)
                .collect(Collectors.toList());
    }

    @Override
    public boolean addEmployee(Employee employee) {
        employee.setId(UUID.randomUUID().toString());
        com.example.demo.entity.Employee savedEntity = employeeDao.save(convertToEntity(employee));
        return savedEntity != null && savedEntity.getId() != null;
    }


    private Employee convertToModel(com.example.demo.entity.Employee employee) {
        Employee emp = new Employee();

        emp.setId(employee.getId());
        emp.setName(employee.getName());
        emp.setAge(employee.getAge());
        emp.setSex(employee.getSex());

        return emp;
    }

    private com.example.demo.entity.Employee convertToEntity(Employee employee) {
        com.example.demo.entity.Employee entity = new com.example.demo.entity.Employee();

        entity.setId(employee.getId());
        entity.setName(employee.getName());
        entity.setAge(employee.getAge());
        entity.setSex(employee.getSex());

        return entity;
    }

}
