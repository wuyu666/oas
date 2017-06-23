package com.chinasofti.oas.mapper;

import java.util.List;

import com.chinasofti.oas.bean.Attendance;
import com.chinasofti.oas.bean.Page;

public interface IAttendanceMapper {
	public List<Attendance> queryAtt(Page <Attendance> page);
	public int queryCount(Page <Attendance> page);;
	public int addNotice(Attendance att);
	public int updateNotice(Attendance att);
	public int deleteNotice(int[] aid);
}
