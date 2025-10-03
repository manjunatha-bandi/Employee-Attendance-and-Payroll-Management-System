package main;

import java.sql.Date;
import java.time.LocalDate;

import DAO.AttendanceDAO;
import config.model.Attendance;

public class MarkAttendance {

	public static void main(String[] args) {
		AttendanceDAO dao = new AttendanceDAO();
		Attendance att = new Attendance(
				2,Date.valueOf(LocalDate.now()),"Present");
		dao.markAttendance(att);
		 System.out.println("Attendance marked successfully for EMP_ID: " + att.getEmpId());

	}

}
