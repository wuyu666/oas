package com.chinasofti.oas.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Attendance {
	private Integer aid;
	//打卡时的时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date auptime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date adowntime;
	//状态0为正常，1为迟到，2为旷工，3为请假
	private String astate;
	//规定的上下班时间
	private String startDate;
	private String endDate;
	
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	
	public Date getAuptime() {
		return auptime;
	}
	public void setAuptime(Date auptime) {
		this.auptime = auptime;
	}
	public Date getAdowntime() {
		return adowntime;
	}
	public void setAdowntime(Date adowntime) {
		this.adowntime = adowntime;
	}
	public String getAstate() {
		return astate;
	}
	public void setAstate(String astate) {
		this.astate = astate;
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
		return "Attendance [aid=" + aid + ", auptime=" + auptime + ", adowntime=" + adowntime + ", astate=" + astate
				+ "]";
	}
	
}
