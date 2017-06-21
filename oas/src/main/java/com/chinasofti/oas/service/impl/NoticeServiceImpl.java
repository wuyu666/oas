package com.chinasofti.oas.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinasofti.oas.mapper.INoticeMapper;
import com.chinasofti.oas.bean.Notice;
import com.chinasofti.oas.service.INoticeService;
@Service
public class NoticeServiceImpl implements INoticeService{
	@Resource
	private INoticeMapper nomapper;
	  
	@Override
	public List<Notice> queryNotice(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return nomapper.queryNotice(map);
	}

	@Override
	public long queryCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return nomapper.queryCount(map);
	}

	@Override
	public boolean add(Notice no) {
		int row=nomapper.add(no);
		if(row>0)
			return true;
		
		return false;
	}

	@Override
	public boolean update(Notice no) {
		int row=nomapper.update(no);
		if(row>0)
			return true;
		
		return false;
	}

	@Override
	public int delete(Integer nid) {
		// TODO Auto-generated method stub
		return nomapper.delete(nid);
	}

	
}
