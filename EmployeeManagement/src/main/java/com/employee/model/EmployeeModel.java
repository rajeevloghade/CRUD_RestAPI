package com.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NamedQueries(value = { @NamedQuery(name = "getAllEmployee", query = "Select e from EmployeeManagement e"),
		@NamedQuery(name = "deleteEmployee", query = "delete from EmployeeManagement e where e.id= :id") })

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Integer id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Department")
	private String department;

	@Column(name = "Address")
	private String address;

}
