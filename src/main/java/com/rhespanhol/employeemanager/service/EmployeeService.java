package com.rhespanhol.employeemanager.service;

import com.rhespanhol.employeemanager.exception.UserNotFoundException;
import com.rhespanhol.employeemanager.model.Employee;
import com.rhespanhol.employeemanager.repo.EmployeeRepo;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeService {

  private final EmployeeRepo employeeRepo;

  public Employee addEmployee(Employee employee) {
    employee.setEmployeeCode(UUID.randomUUID().toString());
    return employeeRepo.save(employee);
  }

  public List<Employee> findAllEmployees() {
    return employeeRepo.findAll();
  }

  public Employee updateEmployee(Employee employee) {
    return employeeRepo.save(employee);
  }

  public void deleteEmployee(Long id) {
    employeeRepo.deleteEmployeeById(id);
  }

  public Employee findEmployeeById(Long id) {
    return employeeRepo.findEmployeeById(id)
        .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
  }
}
