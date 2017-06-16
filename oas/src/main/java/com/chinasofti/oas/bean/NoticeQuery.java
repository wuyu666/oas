package com.chinasofti.oas.bean;

public class NoticeQuery {
	/**
	 * 查询条件
	 */
//	公告范围
	private String nrange;
//	创建时间范围
	private String startDate;
	private String endDate;
	public String getNrange() {
		return nrange;
	}
	public void setNrange(String nrange) {
		this.nrange = nrange;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "NoticeQuery [nrange=" + nrange + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
}
