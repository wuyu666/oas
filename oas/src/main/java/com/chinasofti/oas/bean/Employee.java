package com.chinasofti.oas.bean;

public class Employee {
	/**
	 * 员工id
	 */
	private Integer eid;
	/**
	 * 员工编号
	 */
	private String enumber;
	/**
	 * 员工名字
	 */
	private String ename;
	/**
	 * 员工性别
	 */
	private String esex;
	/**
	 * 员工年龄
	 */
	private int eage;
	/**
	 * 员工所在部门
	 */
	private Department department;
	/**
	 * 员工所在职位
	 */
	private Position position;
	/**
	 * 员工薪资
	 */
	private Salary salary;
	/**
	 * 员工电话号码
	 */
	private String etel;
	/**
	 * 员工住址
	 */
	private String eaddress;
	/**
	 * 员工电子邮箱
	 */
	private String eemail;
	/**
	 * 员工入职日期
	 */
	private String eentrydate;
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEnumber() {
		return enumber;
	}
	public void setEnumber(String enumber) {
		this.enumber = enumber;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEsex() {
		return esex;
	}
	public void setEsex(String esex) {
		this.esex = esex;
	}
	public int getEage() {
		return eage;
	}
	public void setEage(int eage) {
		this.eage = eage;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Salary getSalary() {
		return salary;
	}
	public void setSalary(Salary salary) {
		this.salary = salary;
	}
	public String getEtel() {
		return etel;
	}
	public void setEtel(String etel) {
		this.etel = etel;
	}
	public String getEaddress() {
		return eaddress;
	}
	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}
	public String getEemail() {
		return eemail;
	}
	public void setEemail(String eemail) {
		this.eemail = eemail;
	}
	public String getEentrydate() {
		return eentrydate;
	}
	public void setEentrydate(String eentrydate) {
		this.eentrydate = eentrydate;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", enumber=" + enumber + ", ename=" + ename + ", esex=" + esex + ", eage="
				+ eage + ", department=" + department + ", position=" + position + ", salary=" + salary + ", etel="
				+ etel + ", eaddress=" + eaddress + ", eemail=" + eemail + ", eentrydate=" + eentrydate + "]";
	}
	
} 
