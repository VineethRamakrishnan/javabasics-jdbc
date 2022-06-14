package org.vineeth.hibernate.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.vineeth.hibernate.entities.Employees;

public class HibernateCRUDServiceImpl implements HibernateCRUDService {

	private SessionFactory sessionFactory;
	
	/**
	 * To interact with db through hibernate, we have to follow below steps:
	 * 		1.	SessionFactory Creation	//Only once for the application - application of singleton
	 * 		2.	create session for each case
	 * 		3.	begin and transaction	//Try implementing error handling
	 */
	private void createSessionFactory() {
		
		//TODO: Make it singleton object
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	@Override
	public void insertEmployee(int empId, String empName, int deptId) {
		
		Employees emp = new Employees();
		emp.setEmpName(empName);
		emp.setDeptId(deptId);
		emp.setEmpId(empId);		//Even primary key been auto-generated, it can accept values; need to give explicitly
		
		createSessionFactory();
		
		Session insertSession = sessionFactory.openSession();
		insertSession.beginTransaction();
		insertSession.save(emp);
		insertSession.getTransaction().commit();
		
	}

	@Override
	public void updateEmployeeName(int empId, String updatedEmpName) {
		
		createSessionFactory();
		
		Session updateSession = sessionFactory.openSession();
		updateSession.beginTransaction();
		//Employees emp = updateSession.g
		updateSession.update(updatedEmpName, updateSession);
		updateSession.getTransaction().commit();
		
	}

	@Override
	public void selectEmployee(int empId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		
	}

}
