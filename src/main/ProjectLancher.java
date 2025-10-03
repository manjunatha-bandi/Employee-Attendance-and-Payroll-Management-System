package main;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import DAO.AttendanceDAO;
import DAO.EmployeeDAO;
import DAO.PayrollDAO;
import config.model.Attendance;
import config.model.Payroll;

public class ProjectLancher {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        AttendanceDAO attDao = new AttendanceDAO();

        System.out.println(" Welcome to Attendance Management System");
        System.out.println("1. Mark Attendance");
        System.out.println("2. View All Attendance");
        System.out.println("3. Filter by Employee");
        System.out.println("4. Filter by Date");
        System.out.println("5. Add Payroll");
        System.out.println("6. View Payroll by Employee");
        System.out.println("7. View All Payrolls");

        while (true) {
            System.out.print("\nChoose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter EMP_ID: ");
                    int empId = sc.nextInt();
                    System.out.print("Enter Status (Present/Absent/Leave): ");
                    String status = sc.next();
                    Attendance att = new Attendance(empId, Date.valueOf(LocalDate.now()), status);
                    attDao.markAttendance(att);
                    System.out.println(" Attendance marked.");
                    break;

                case 2:
                    attDao.getAllAttendance().forEach(a ->
                        System.out.println("ATT_ID: " + a.getAttId() + ", EMP_ID: " + a.getEmpId() +
                                           ", DATE: " + a.getAttDate() + ", STATUS: " + a.getStatus()));
                    break;

                case 3:
                    System.out.print("Enter EMP_ID: ");
                    int filterEmpId = sc.nextInt();
                    attDao.getAttendanceByEmployee(filterEmpId).forEach(a ->
                        System.out.println("DATE: " + a.getAttDate() + ", STATUS: " + a.getStatus()));
                    break;

                case 4:
                    System.out.print("Enter Date (yyyy-mm-dd): ");
                    String dateStr = sc.next();
                    Date filterDate = Date.valueOf(dateStr);
                    attDao.getAttendanceByDate(filterDate).forEach(a ->
                        System.out.println("EMP_ID: " + a.getEmpId() + ", STATUS: " + a.getStatus()));
                    break;

                case 5:
                    System.out.print("Enter EMP_ID: ");
                    int empId1 = sc.nextInt();

                    // Fetch base salary from EMPLOYEES table
                    EmployeeDAO empDao = new EmployeeDAO();
                    double basicSalary = empDao.getBaseSalary(empId1);
                    System.out.println("Fetched Base Salary: ₹" + basicSalary);

                    System.out.print("Enter Deductions: ");
                    double deductions = sc.nextDouble();
                    System.out.print("Enter Bonuses: ");
                    double bonuses = sc.nextDouble();
                    sc.nextLine(); // consume newline
                    double total = basicSalary + bonuses - deductions;
           
                    Payroll payroll = new Payroll(empId1, basicSalary, deductions, bonuses, total );
                    PayrollDAO payrollDao = new PayrollDAO();
                    payrollDao.addPayroll(payroll);
                    break;
                case 6:
                    System.out.print("Enter EMP_ID: ");
                    int viewEmpId = sc.nextInt();

                    PayrollDAO payrollDao1 = new PayrollDAO();
                    List<Payroll> empPayrolls = PayrollDAO.getPayrollByEmployee(viewEmpId);

                    if (empPayrolls.isEmpty()) {
                        System.out.println("No payroll records found for EMP_ID: " + viewEmpId);
                    } else {
                        for (Payroll p : empPayrolls) {
                            System.out.println("PAY_ID: " + p.getEmpId() +
                                               ", BASIC: ₹" + p.getBasicSalary() +
                                               ", DEDUCTIONS: ₹" + p.getDeductions() +
                                               ", BONUSES: ₹" + p.getBonuses() +
                                               ", TOTAL SALARY: ₹" + p.getTotalSalary());
                        }
                    }
                    break;
                case 7:
                    PayrollDAO payrollDao2 = new PayrollDAO();
                    List<Payroll> allPayrolls = PayrollDAO.getAllPayrolls();

                    if (allPayrolls.isEmpty()) {
                        System.out.println("No payroll records found.");
                    } else {
                        for (Payroll p : allPayrolls) {
                            System.out.println("PAY_ID: " + p.getEmpId() +
                                               ", EMP_ID: " + p.getEmpId() +
                                               ", BASIC: ₹" + p.getBasicSalary() +
                                               ", DEDUCTIONS: ₹" + p.getDeductions() +
                                               ", BONUSES: ₹" + p.getBonuses() +
                                               ", TOTAL SALARY: ₹" + p.getTotalSalary());
                        }
                    }
                    break;
                default:
                    System.out.println(" Invalid choice. Try again.");

	}
        }
}
}