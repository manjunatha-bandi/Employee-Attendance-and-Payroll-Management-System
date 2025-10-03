package main;

import DAO.EmployeeDAO;
import config.model.Employee;

public class TestInsertEmployee {
	public static void main(String[] args) {
		// CreatING an employee object
        Employee emp = new Employee
        		(1, "B.Manjunatha", "JAVA DEVELOPER", 55000.0, "manju.b@example.com");

        // CreatING DAO object
        EmployeeDAO dao = new EmployeeDAO();

        // Test addEmployee
        dao.addEmployee(new Employee(0, "Ravi", "HR", 40000.0, "ravi@example.com"));
        dao.addEmployee(new Employee(0, "Arjun", "IT", 80000.0, "arjun@gmail.com"));
        dao.addEmployee(new Employee(0, "RAJU", "SALES", 30000.0, "RAJU@gmail.com"));
        dao.addEmployee(new Employee(0, "JACK", "PYTHON DEVELOPER", 50000.0, "JACK@gmail.com"));
        dao.addEmployee(new Employee(0, "VIKRAM", "MANAGER", 90000.0, "vikram@gmail.com"));

        // Test updateEmployee
        dao.addEmployee(emp);
	}
}
