package com.employee.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.employee.model.EmployeeModel;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Repository("EmployeeDaoImpl")
public class EmployeeDaoImpl implements EmployeeDao {

	public static final String STATUS = "status";
	public static final String SUCCESS = "success";
	public static final String FAILURE = "failure";

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<EmployeeModel> getAllEmployee() {
		log.info("inside @getAllEmployee method:{}");
		try {
			Query query = entityManager.createNamedQuery("getAllEmployee");
			return query.getResultList();
		} catch (NoResultException e) {
			log.error("Error occuring while getting list of employee :{}");
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Error occuring while getting list of employee :{}");
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	@Override
	public List<EmployeeModel> putEmployee(EmployeeModel employeeModel) {
		log.info("inside @putEmployee method taking EmployeeModel object :{}", employeeModel);
		try {
			EmployeeModel model = new EmployeeModel();
			model.setName(employeeModel.getName());
			model.setDepartment(employeeModel.getDepartment());
			model.setAddress(employeeModel.getAddress());
			entityManager.persist(model);
		} catch (Exception e) {
			log.error("Error occuring while inserting employee :{}");
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	@Override
	public Map<String, String> update(Integer id, String name, String department, String address) {
		log.info("inside @updateEmployee method taking arguments:{}", id, name, department, address);
		Map<String, String> responseMap = new HashMap<>();
		try {
			Query query = entityManager.createNamedQuery("updateEmployee");
			query.setParameter("id", id);
			query.setParameter("name", name);
			query.setParameter("department", department);
			query.setParameter("address", address);
			query.executeUpdate();
			responseMap.put(STATUS, SUCCESS);
		} catch (Exception e) {
			log.error("Error occuring while updating employee :{}");
			e.printStackTrace();
			responseMap.put(STATUS, FAILURE);
		}
		return responseMap;
	}

	@Override
	public Map<String, String> delete(Integer id) {
		log.info("inside @deleteEmployee method taking id:{}", id);
		Map<String, String> responseMap = new HashMap<>();
		try {
			Query query = entityManager.createNamedQuery("deleteEmployee");
			query.setParameter("id", id).executeUpdate();
			responseMap.put(STATUS, SUCCESS);
		} catch (Exception e) {
			log.error("Error occuring while deleting employee :{}");
			e.printStackTrace();
			responseMap.put(STATUS, FAILURE);
		}
		return responseMap;
	}

}
