package main;

import DAO.EmployeeDAO;
import config.model.Employee;

public class UpdateEmployee {

	public static void main(String[] args) {
		// Update employee with ID 1
        Employee updatedEmp = new Employee(3, "Manjunatha R", "IT", 60000.0, "manju.r@example.com");

        EmployeeDAO dao = new EmployeeDAO();
        dao.UpdateEmployee(updatedEmp);
    }


	}