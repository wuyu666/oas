package com.chinasofti.oas.bean;
/**
 * 职位对象类
 * @author wy
 * 2017年6月15日
 */
public class Position {
	/**
	 * 职位id
	 */
	private Integer pid;
	/**
	 * 职位名称
	 */
	private String pname;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	@Override
	public String toString() {
		return "Position [pid=" + pid + ", pname=" + pname + "]";
	}
	
}
