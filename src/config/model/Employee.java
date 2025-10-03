package config.model;

public class Employee {
	private int emp_id;
	private String name;
	private String department;
	private double salary;
	private String email;
	//constructor with args
	public Employee(int emp_id, String name, String department, double salary, String email) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.email = email;	
	}
	//Getters &setters
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
