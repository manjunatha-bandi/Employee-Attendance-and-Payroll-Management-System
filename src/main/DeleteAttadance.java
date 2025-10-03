package main;

import DAO.AttendanceDAO;

public class DeleteAttadance {

	public static void main(String[] args) {
		 AttendanceDAO dao = new AttendanceDAO();

	        int attIdToDelete = 1; // Replace with a valid ATT_ID from your table

	        dao.deleteAttendance(attIdToDelete);
	        System.out.println("🗑️ Attendance record deleted for ATT_ID: " + attIdToDelete);

	}

}
