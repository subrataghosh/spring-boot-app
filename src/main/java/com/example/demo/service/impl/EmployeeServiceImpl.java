package com.example.demo.service.impl;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.entity.Dependent;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        com.example.demo.entity.Employee savedEntity = employeeDao.save(convertToEntity(employee));
        return savedEntity != null && savedEntity.getId() != null;
    }

    @Override
    public Employee getEmployeeById(String employeeId) {
        Optional<com.example.demo.entity.Employee> employeeEnity = employeeDao.findById(employeeId);
        return convertToModel(employeeEnity.get());
    }


    private Employee convertToModel(com.example.demo.entity.Employee employee) {
        Employee emp = new Employee();

        emp.setId(employee.getId());
        emp.setName(employee.getName());
        emp.setAge(employee.getAge());
        emp.setSex(employee.getSex());

        return emp;
    }

    private com.example.demo.entity.Employee convertToEntity(Employee emp) {

        com.example.demo.entity.Employee employee = new com.example.demo.entity.Employee();
        employee.setId(UUID.randomUUID().toString());
        employee.setName(emp.getName());
        employee.setAge(emp.getAge());
        employee.setSex(emp.getSex());

        List<Dependent> dependents = emp.getDependents().stream().map(dependentDTO -> {
            Dependent dependent = new Dependent();
            dependent.setId(UUID.randomUUID().toString());
            dependent.setName(dependentDTO.getName());
            dependent.setRelation(dependentDTO.getRelation());
            dependent.setEmployee(employee);
            return dependent;
        }).collect(Collectors.toList());

        employee.setDependents(dependents);

        return employee;
    }

}
