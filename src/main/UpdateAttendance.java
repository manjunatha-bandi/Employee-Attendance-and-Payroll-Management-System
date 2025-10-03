package main;

import DAO.AttendanceDAO;

public class UpdateAttendance {

	public static void main(String[] args) {
		AttendanceDAO dao = new AttendanceDAO();

        int attIdToUpdate = 1;           // Replace with a valid ATT_ID from your table
        String newStatus = "Present";    // New status to update

        dao.updateAttendanceStatus(attIdToUpdate, newStatus);
        System.out.println("Attendance status updated for ATT_ID: " + attIdToUpdate);

	}

}
