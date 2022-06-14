package org.vineeth.hibernate.service;

public interface HibernateCRUDService {

	
	public void insertEmployee(int empId, String empName, int deptId);
	
	public void updateEmployeeName(int empId, String updatedEmpName);
	
	public void selectEmployee(int empId);
	
	public void deleteEmployee(int empId);
	
}
