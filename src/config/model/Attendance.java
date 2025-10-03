package config.model;

import java.sql.Date;

public class Attendance {
	private int attId;
    private int empId;
    private Date attDate;
    private String status;
	public Attendance(int empId, Date attDate, String status) {
		super();
		this.empId = empId;
		this.attDate = attDate;
		this.status = status;
	}
	public Attendance(int attId, int empId, Date attDate, String status) {
		super();
		this.attId = attId;
		this.empId = empId;
		this.attDate = attDate;
		this.status = status;
	}
    public Attendance() {}
	public int getAttId() {
		return attId;
	}
	public void setAttId(int attId) {
		this.attId = attId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public Date getAttDate() {
		return attDate;
	}
	public void setAttDate(Date attDate) {
		this.attDate = attDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
}
