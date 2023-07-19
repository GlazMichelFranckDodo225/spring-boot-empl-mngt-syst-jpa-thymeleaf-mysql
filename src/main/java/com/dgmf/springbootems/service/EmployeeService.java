package com.dgmf.springbootems.service;

import com.dgmf.springbootems.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee save(Employee employee);
    Employee getById(Long id);
    void deleteById(Long id);
}
