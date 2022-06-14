package org.vineeth.hibernate.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Employees entity class. It should be matching with table name.
 * Minimum annotations: Entity and Id
 * @author rvineeth
 *
 */
@Entity
public class Employees {

	@Id
	private Integer empId;
	
	private String empName;
	
	private String address;
	
	private Integer deptId;
	
	private Integer salary;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	
}
