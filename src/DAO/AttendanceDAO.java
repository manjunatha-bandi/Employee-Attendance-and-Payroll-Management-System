package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.model.Attendance;

public class AttendanceDAO {
	//Insert into attendance table
	public void markAttendance(Attendance att) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Management_system", "root", "1234");
			//Connection con = DBConnections.getConnection();
			PreparedStatement st = con.prepareStatement("INSERT INTO ATTENDANCE("
					+ "ATT_ID,EMP_ID,DATE,STATUS) VALUES(?,?,?,?)");
			st.setInt(1, att.getAttId());
			st.setInt(2, att.getEmpId());
			st.setDate(3, att.getAttDate());
			st.setString(4, att.getStatus());
			int rows = st.executeUpdate();
			System.out.println("Sucessfully inserted"+rows+" values into Attendance Table");
			st.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Read all data in attendance table
	public List<Attendance> getAllAttendance() {
		List<Attendance> list = new ArrayList<Attendance>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Management_system", "root", "1234");
			PreparedStatement st = con.prepareStatement("SELECT*FROM ATTENDANCE");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Attendance att = new Attendance(
						rs.getInt("ATT_ID"),
						rs.getInt("EMP_ID"),
						rs.getDate("DATE"),
						rs.getString("STATUS")
						);
				list.add(att);
			}
			System.out.println("Successfully Returned all data from Attendance Table");
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//Update (Change Status)
	 public void updateAttendanceStatus(int attId, String newStatus) {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Management_system", "root", "1234");
	            PreparedStatement st = con.prepareStatement("UPDATE ATTENDANCE SET STATUS = ? WHERE ATT_ID = ?");
	            st.setString(1, newStatus);
	            st.setInt(2, attId);
	            st.executeUpdate();
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    //  Delete (Remove Record)
	    public void deleteAttendance(int attId) {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Management_system", "root", "1234");
	            PreparedStatement st = con.prepareStatement("DELETE FROM ATTENDANCE WHERE ATT_ID = ?");
	            st.setInt(1, attId);
	            st.executeUpdate();
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 // Filter attendance by employee ID
	    public List<Attendance> getAttendanceByEmployee(int empId) {
	        List<Attendance> list = new ArrayList<>();
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Management_system", "root", "1234");
	            PreparedStatement st = con.prepareStatement("SELECT * FROM ATTENDANCE WHERE EMP_ID = ?");
	            st.setInt(1, empId);
	            ResultSet rs = st.executeQuery();
	            while (rs.next()) {
	                Attendance att = new Attendance(
	                    rs.getInt("ATT_ID"),
	                    rs.getInt("EMP_ID"),
	                    rs.getDate("DATE"),
	                    rs.getString("STATUS")
	                );
	                list.add(att);
	            }
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
	 // Filter attendance by date
	    public List<Attendance> getAttendanceByDate(Date date) {
	        List<Attendance> list = new ArrayList<>();
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Management_system", "root", "1234");
	            PreparedStatement st = con.prepareStatement("SELECT * FROM ATTENDANCE WHERE DATE = ?");
	            st.setDate(1, date);
	            ResultSet rs = st.executeQuery();
	            while (rs.next()) {
	                Attendance att = new Attendance(
	                    rs.getInt("ATT_ID"),
	                    rs.getInt("EMP_ID"),
	                    rs.getDate("DATE"),
	                    rs.getString("STATUS")
	                );
	                list.add(att);
	            }
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
}
