package com.employee.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.EmployeeModel;
import com.employee.service.EmployeeService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/Employee")
public class EmployeeRestImpl implements EmployeeRest {

	@Autowired
	EmployeeService employeeService;

	@Override
	public List<EmployeeModel> getAllEmployee() {
		log.trace("inside @getAllEmployee method:{}");
		return employeeService.getAllEmployee();
	}

	@Override
	public List<EmployeeModel> putEmployee(@RequestBody EmployeeModel employeeModel) {
		log.trace("inside @putEmployee method taking EmployeeModel object :{}", employeeModel);
		return employeeService.putEmployee(employeeModel);
	}

	@Override
	public Map<String, String> update(@RequestParam(required = false, name = "id") Integer id,
			@RequestParam(required = false, name = "name") String name,
			@RequestParam(required = false, name = "department") String department,
			@RequestParam(required = false, name = "address") String address) {
		log.trace("inside @updateEmployee method taking arguments:{}", id, name, department, address);
		return employeeService.update(id, name, department, address);
	}

	@Override
	public Map<String, String> delete(@PathVariable(value = "id") Integer id) {
		log.trace("inside @deleteEmployee method taking id:{}", id);
		return employeeService.delete(id);
	}

}
