package com.chinasofti.oas.service;


import com.chinasofti.oas.bean.Attendance;
import com.chinasofti.oas.bean.Page;

public interface IAttendanceService {
	public void queryAtt(Page <Attendance> page);
	public int queryCount(Page <Attendance> page);;
	public boolean addNotice(Attendance att);
	public boolean updateNotice(Attendance att);
	public boolean deleteNotice(int[] aid);
}
