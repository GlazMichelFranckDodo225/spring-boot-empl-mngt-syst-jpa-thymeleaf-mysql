package com.dgmf.springbootems.service.impl;

import com.dgmf.springbootems.model.Employee;
import com.dgmf.springbootems.repository.EmployeeRepository;
import com.dgmf.springbootems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        if(Objects.nonNull(employee)) {
            employeeRepository.save(employee);
        }

        return employee;
    }

    @Override
    public Employee getById(Long id) {
        Employee employee = null;

        if(Objects.nonNull(id)) {
            Optional<Employee> optionalEmployee = employeeRepository.findById(id);

            if(optionalEmployee.isPresent()) {
                employee = optionalEmployee.get();
            }
            else {
                throw new RuntimeException("Employee with the " + id + " not found");
            }
        }

        return employee;
    }

    @Override
    public void deleteById(Long id) {
        if(Objects.nonNull(id)) {
            employeeRepository.deleteById(id);
        }
    }
}
