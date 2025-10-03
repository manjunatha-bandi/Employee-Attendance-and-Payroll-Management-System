package config.model;

import java.sql.Date;

public class Payroll {
	private int payrollId;
    private int empId;
    private double basicSalary;
    private double deductions;
    private double bonuses;
    private double totalSalary;
	public Payroll(int payrollId, int empId, double basicSalary, double deductions, double bonuses, double totalSalary) {
		super();
		this.payrollId = payrollId;
		this.empId = empId;
		this.basicSalary = basicSalary;
		this.deductions = deductions;
		this.bonuses = bonuses;
		this.totalSalary = basicSalary+bonuses-deductions;
	}
	public Payroll(int empId, double basicSalary, double deductions, double bonuses,double totalSalary) {
		super();
		this.empId = empId;
		this.basicSalary = basicSalary;
		this.deductions = deductions;
		this.bonuses = bonuses;
		this.totalSalary = basicSalary+bonuses-deductions;
	}
	public int getPayrollId() {
		return payrollId;
	}
	public void setPayrollId(int payrollId) {
		this.payrollId = payrollId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	public double getDeductions() {
		return deductions;
	}
	public void setDeductions(double deductions) {
		this.deductions = deductions;
	}
	public double getBonuses() {
		return bonuses;
	}
	public void setBonuses(double bonuses) {
		this.bonuses = bonuses;
	}
	public double getTotalSalary() {
		return totalSalary;
	}
	public void setTotalSalary(double totalSalary) {
		this.totalSalary = totalSalary;
	}
	
    
}
