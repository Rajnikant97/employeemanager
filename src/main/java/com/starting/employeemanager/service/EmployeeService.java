package com.starting.employeemanager.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.starting.employeemanager.exception.UserNotFoundException;
import com.starting.employeemanager.model.Employee;
import com.starting.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployee() {
        return employeeRepo.findAll();
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(()-> new UserNotFoundException("User By id = " + id + " not found"));
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(Long id) {
        System.out.println("service id : "+id);
//        employeeRepo.deleteEmployeeById(id);
        employeeRepo.delete(findEmployeeById(id));
//        System.out.println("here");
    }
}
