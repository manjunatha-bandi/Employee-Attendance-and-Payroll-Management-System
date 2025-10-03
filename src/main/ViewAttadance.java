package main;

import java.util.List;

import config.model.Attendance;
import DAO.AttendanceDAO;

public class ViewAttadance {

	public static void main(String[] args) {
		AttendanceDAO dao = new AttendanceDAO();
		List<Attendance> list = dao.getAllAttendance() ;
		
		if(list.isEmpty()) {
			System.out.println("No Attadance Records Found.");
		}else {
			System.out.println("Attadance Records:");
			System.out.println("--------------------------------------------------");
			for(Attendance att: list) {
				System.out.println("ATT_ID   : " + att.getAttId());
	            System.out.println("EMP_ID   : " + att.getEmpId());
	            System.out.println("DATE     : " + att.getAttDate());
	            System.out.println("STATUS   : " + att.getStatus());
	            System.out.println("--------------------------------------------------");
			}
		}

	}

}
