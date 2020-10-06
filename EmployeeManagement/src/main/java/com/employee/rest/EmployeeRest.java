package com.employee.rest;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.model.EmployeeModel;

public interface EmployeeRest {

	@GetMapping("/getAllEmployee")
	List<EmployeeModel> getAllEmployee();

	@PostMapping(value = "/putEmployee", consumes = "application/json", produces = "application/json")
	List<EmployeeModel> putEmployee(EmployeeModel employeeModel);

	@GetMapping(value = "updateEmployee", produces = "application/json")
	Map<String, String> update(Integer id, String name, String department, String address);

	@GetMapping("deleteEmployee/{id}")
	Map<String, String> delete(Integer id);
}
