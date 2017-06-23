package com.chinasofti.oas.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinasofti.oas.bean.Attendance;
import com.chinasofti.oas.bean.Page;
import com.chinasofti.oas.mapper.IAttendanceMapper;
import com.chinasofti.oas.service.IAttendanceService;
@Service("attendanceService")
public class AttendanceServiceImpl implements IAttendanceService{
	@Resource	
	private IAttendanceMapper attMapper;
	@Override
	public void queryAtt(Page<Attendance> page) {
		List<Attendance> list=attMapper.queryAtt(page);
		int total=attMapper.queryCount(page);
		page.setRows(list);
		page.setTotal(total);
	}

	@Override
	public int queryCount(Page<Attendance> page) {
		// TODO Auto-generated method stub
		return attMapper.queryCount(page);
	}

	@Override
	public boolean addNotice(Attendance att) {
		int rows=attMapper.addNotice(att);
		if(rows>0)
			return true;
		return false;
	}

	@Override
	public boolean updateNotice(Attendance att) {
		int rows=attMapper.updateNotice(att);
		if(rows>0)
			return true;
		return false;
	}

	@Override
	public boolean deleteNotice(int[] aid) {
		int rows=attMapper.deleteNotice(aid);
		if(rows>0)
			return true;
		return false;
	}

}
