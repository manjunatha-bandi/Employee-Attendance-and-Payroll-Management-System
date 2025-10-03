package main;

import java.util.List;

import DAO.EmployeeDAO;
import config.model.Employee;

public class ReadEmployees {

	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
      List<Employee> list =dao.ReadEmployee(null);
      if (list.isEmpty()) {
          System.out.println("No employee records found.");
      } else {
          System.out.println(" Employee List:");
          System.out.println("--------------------------------------------------");
          for (Employee emp : list) {
        	  System.out.println("ID: " + emp.getEmp_id()); 
              System.out.println("Name: " + emp.getName());
              System.out.println("Department: " + emp.getDepartment());
              System.out.println("Salary: " + emp.getSalary());
              System.out.println("Email: " + emp.getEmail());
              System.out.println("-----------------------------");
          }

	}

}
}