package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.model.Payroll;

public class PayrollDAO {
	 public void addPayroll(Payroll p) {
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Management_system", "root", "1234");
			PreparedStatement st = con.prepareStatement(
	                 "INSERT INTO PAYROLL (EMP_ID, BASIC_SALARY, DEDUCTIONS, BONUSES, TOTAL_SALARY) VALUES (?, ?, ?, ?, ?)");
	            st.setInt(1, p.getEmpId());
	            st.setDouble(2, p.getBasicSalary());
	            st.setDouble(3, p.getDeductions());
	            st.setDouble(4, p.getBonuses());
	            st.setDouble(5, p.getTotalSalary());
	            st.executeUpdate();
	            System.out.println(" Payroll record added for EMP_ID " + p.getEmpId());

		 } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 public static List<Payroll> getPayrollByEmployee(int empId) {
	        List<Payroll> list = new ArrayList<>();
	        try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Management_system", "root", "1234");
				PreparedStatement st = con.prepareStatement("SELECT * FROM PAYROLL WHERE EMP_ID = ?");
				st.setInt(1, empId);
	            ResultSet rs = st.executeQuery();
	            while (rs.next()) {
	                Payroll p = new Payroll(
	                    rs.getInt("PAY_ID"),
	                    rs.getInt("EMP_ID"),
	                    rs.getDouble("BASIC_SALARY"),
	                    rs.getDouble("DEDUCTIONS"),
	                    rs.getDouble("BONUSES"),
	                    rs.getDouble("TOTAL_SALARY")
	                );
	                list.add(p);
	            }

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
	 }
	 public static List<Payroll> getAllPayrolls() {
	        List<Payroll> list = new ArrayList<>();
	        try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Management_system", "root", "1234");
				PreparedStatement st = con.prepareStatement("SELECT * FROM PAYROLL");
				 ResultSet rs = st.executeQuery();
			            while (rs.next()) {
			                Payroll p = new Payroll(
			                    rs.getInt("PAY_ID"),
			                    rs.getInt("EMP_ID"),
			                    rs.getDouble("BASIC_SALARY"),
			                    rs.getDouble("DEDUCTIONS"),
			                    rs.getDouble("BONUSES"),
			                    rs.getDouble("TOTAL_SALARY")
			                );
			                list.add(p);
			            }
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
	 }
}
