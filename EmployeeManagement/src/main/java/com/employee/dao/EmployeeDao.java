package com.employee.dao;

import java.util.List;
import java.util.Map;

import com.employee.model.EmployeeModel;

public interface EmployeeDao {

	List<EmployeeModel> getAllEmployee();

	List<EmployeeModel> putEmployee(EmployeeModel employeeModel);

	Map<String, String> update(Integer id, String name, String department, String address);

	Map<String, String> delete(Integer id);
}
