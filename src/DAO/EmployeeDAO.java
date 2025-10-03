package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.model.Employee;

public class EmployeeDAO {

	public void addEmployee(Employee emp) {
		//creating
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Management_system", "root",
					"1234");
			PreparedStatement st = con
					.prepareStatement("INSERT INTO EMPLOYEES(" + "NAME,DEPARTMENT,BASE_SALARY,EMAIL)VALUES(?,?,?,?)");
			st.setString(1, emp.getName());
			st.setString(2, emp.getDepartment());
			st.setDouble(3, (int) emp.getSalary());
			st.setString(4, emp.getEmail());
			int rows = st.executeUpdate();
			System.out.println(rows+" Employess add to table");
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//update records
	public void UpdateEmployee(Employee emp) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Management_system", "root",
				"1234");
		 PreparedStatement st = con.prepareStatement(
	                "UPDATE EMPLOYEES SET NAME = ?, DEPARTMENT = ?, BASE_SALARY = ?, EMAIL = ? WHERE EMP_ID = ?");
		 st.setString(1, emp.getName());
         st.setString(2, emp.getDepartment());
         st.setDouble(3, emp.getSalary());
         st.setString(4, emp.getEmail());
         st.setInt(5, emp.getEmp_id());

         int rows = st.executeUpdate();
         System.out.println(rows + " employee(s) updated successfully.");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	//delete records
	public void deleteEmployee(int empId) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Management_system", "root",
					"1234");
			PreparedStatement st = con.prepareStatement("DELETE FROM EMPLOYEES WHERE EMP_ID = ?"); 

	            st.setInt(1, empId);
	            int rows = st.executeUpdate();
	            System.out.println(rows + " employee(s) deleted successfully.");
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	}
	//read details
	public List<Employee> ReadEmployee(Employee emp) {
		List<Employee> employees=new  ArrayList<Employee>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Management_system", "root",
					"1234");
			PreparedStatement st = con.prepareStatement("SELECT*FROM EMPLOYEES");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				 Employee emp1 = new Employee(
		                    rs.getInt("EMP_ID"),
		                    rs.getString("NAME"),
		                    rs.getString("DEPARTMENT"),
		                    rs.getDouble("BASE_SALARY"),
		                    rs.getString("EMAIL")
		                );
		                employees.add(emp1);

			}
		 } catch (ClassNotFoundException | SQLException e) {
		        e.printStackTrace();
		 }
		return employees;
	}
	public double getBaseSalary(int empId) {
	    double salary = 0.0;
	    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Management_system", "root", "1234");
	         PreparedStatement ps = con.prepareStatement("SELECT BASE_SALARY FROM EMPLOYEES WHERE EMP_ID = ?")) {

	        ps.setInt(1, empId);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            salary = rs.getDouble("BASE_SALARY");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return salary;
	}
}