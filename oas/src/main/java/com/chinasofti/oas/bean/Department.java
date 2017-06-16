package com.chinasofti.oas.bean;

import java.util.List;

/**
 * 部门对象类
 * @author wy
 * 2017年6月15日
 */
public class Department {
	/**
	 * 部门id
	 */
	private int did;
	/**
	 * 部门编号
	 */
	private String dnumber;
	/**
	 * 部门名字
	 */
	private String dname;
	/**
	 * 部门职位
	 */
	private List<Position> positions;
	
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDnumber() {
		return dnumber;
	}
	public void setDnumber(String dnumber) {
		this.dnumber = dnumber;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public List<Position> getPositions() {
		return positions;
	}
	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}
	@Override
	public String toString() {
		return "Department [did=" + did + ", dnumber=" + dnumber + ", dname=" + dname + ", positions=" + positions
				+ "]";
	}

	
}
