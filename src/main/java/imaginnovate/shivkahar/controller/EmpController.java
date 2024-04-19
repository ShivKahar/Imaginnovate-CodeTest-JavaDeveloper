package imaginnovate.shivkahar.controller;

import org.springframework.http.ResponseEntity;

import imaginnovate.shivkahar.model.Employee;

public interface EmpController {
	ResponseEntity<?> addEmployee(Employee employee);
    ResponseEntity<?> getEmployeesTaxDeduction();
}
