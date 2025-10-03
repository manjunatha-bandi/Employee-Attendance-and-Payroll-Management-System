package main;

import DAO.EmployeeDAO;

public class TestDeleteEmployee {
	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
		dao.deleteEmployee(5);
	}
}
