package org.vineeth.hibernate;

import org.vineeth.hibernate.service.HibernateCRUDService;
import org.vineeth.hibernate.service.HibernateCRUDServiceImpl;

public class HibernateTutorialMainApplication {

	public static void main(String[] args) {
		
		HibernateCRUDService service = new HibernateCRUDServiceImpl();
		service.insertEmployee(1001, "Vineeth", 103);

	}

}
