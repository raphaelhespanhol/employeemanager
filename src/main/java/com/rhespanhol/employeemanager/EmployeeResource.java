package com.rhespanhol.employeemanager;

import com.rhespanhol.employeemanager.model.Employee;
import com.rhespanhol.employeemanager.service.EmployeeService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeResource {

  private final EmployeeService employeeService;

  @GetMapping("/all")
  public ResponseEntity<List<Employee>> getAllEmployees() {
    final var employees = employeeService.findAllEmployees();
    return new ResponseEntity<>(employees, HttpStatus.OK);
  }

  @GetMapping("/find/{id}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
    final var employee = employeeService.findEmployeeById(id);
    return new ResponseEntity<>(employee, HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
    final var newEmployee = employeeService.addEmployee(employee);
    return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
  }

  @PutMapping("/update")
  public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
    final var updateEmployee = employeeService.addEmployee(employee);
    return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
    employeeService.deleteEmployee(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}

