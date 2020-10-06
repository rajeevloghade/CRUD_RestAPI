package com.employee.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDao;
import com.employee.model.EmployeeModel;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service("EmployeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {

	private @Autowired EmployeeDao employeeDao;

	@Override
	public List<EmployeeModel> getAllEmployee() {
		log.debug("inside @getAllEmployee method:{}");
		return employeeDao.getAllEmployee();
	}

	@Override
	public List<EmployeeModel> putEmployee(EmployeeModel employeeModel) {
		log.debug("inside @putEmployee method taking EmployeeModel object :{}", employeeModel);
		return employeeDao.putEmployee(employeeModel);
	}

	@Override
	public Map<String, String> update(Integer id, String name, String department, String address) {
		log.debug("inside @updateEmployee method taking arguments:{}", id, name, department, address);
		return employeeDao.update(id, name, department, address);
	}

	@Override
	public Map<String, String> delete(Integer id) {
		log.debug("inside @deleteEmployee method taking id:{}", id);
		return employeeDao.delete(id);
	}

}
