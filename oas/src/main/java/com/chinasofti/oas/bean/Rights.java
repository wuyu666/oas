package com.chinasofti.oas.bean;
/**
 * 权限管理类
 * @author 曾欢
 * 2017年6月15日
 */
public class Rights {
	/**
	 * 权限id
	 */
	private Integer rid;
	/**
	 * 权限名字
	 */
	private String rname;
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	@Override
	public String toString() {
		return "Right [rid=" + rid + ", rname=" + rname + "]";
	}
	
	
}
