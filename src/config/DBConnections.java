package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnections {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Management_system", "root", "1234");
			Statement st = con.createStatement();
			//Employee Table
			int EmployeeTable = st.executeUpdate("CREATE TABLE EMPLOYEES("
					+ "EMP_ID INT AUTO_INCREMENT PRIMARY KEY,"
					+ "NAME VARCHAR(30),"
					+ "DEPARTMENT VARCHAR(30),"
					+ "BASE_SALARY DOUBLE NOT NULL,"
					+ "EMAIL VARCHAR(40) UNIQUE)");
			System.out.println("Employee Table Created successfully!!!");
			System.out.println(EmployeeTable);
			//Attendance Table
			int AttendanceTable = st.executeUpdate("CREATE TABLE ATTENDANCE("
					+ "Att_ID INT AUTO_INCREMENT PRIMARY KEY,"
					+ "EMP_ID INT ,"
					+ "DATE DATE NOT NULL,"
					+ "STATUS ENUM('PRESENT','ABSENT','LEAVE') DEFAULT 'PRESENT',"
					+ "FOREIGN KEY (EMP_ID) REFERENCES EMPLOYEES (EMP_ID)"
					+ " ON DELETE CASCADE)");
			System.out.println("Attadance Table Created successfully!!!");
			System.out.println(AttendanceTable);
			//PAY Roll Table
			int PayrollTable = st.executeUpdate("CREATE TABLE PAYROLL("
					+ "PAY_ID INT AUTO_INCREMENT PRIMARY KEY,"
					+ "EMP_ID INT ,"
					+ "BASIC_SALARY DOUBLE NOT NULL,"
					+ "DEDUCTIONS DOUBLE DEFAULT 0,"
					+ "BONUSES DOUBLE DEFAULT 0,"
					+ "TOTAL_SALARY DOUBLE NOT NULL,"
					+ "FOREIGN KEY(EMP_ID) REFERENCES EMPLOYEES (EMP_ID)"
					+ " ON DELETE CASCADE) ");
			System.out.println("PayRoll Table Created successfully!!!");
			System.out.println(PayrollTable);
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
}