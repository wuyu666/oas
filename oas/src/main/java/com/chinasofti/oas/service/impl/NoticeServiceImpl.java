package com.chinasofti.oas.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinasofti.oas.mapper.INoticeMapper;
import com.chinasofti.oas.bean.Notice;
import com.chinasofti.oas.bean.Page;
import com.chinasofti.oas.service.INoticeService;
@Service("noticeService")
public class NoticeServiceImpl implements INoticeService{
	@Resource
	private INoticeMapper nomapper;
	  
	@Override
	public void queryNotice(Page<Notice> page) {
		List<Notice> list=nomapper.queryNotice(page);
		int total=nomapper.queryCount(page);
		page.setRows(list);
		page.setTotal(total);
	}

	@Override
	public int queryCount(Page<Notice> page) {
		// TODO Auto-generated method stub
		return nomapper.queryCount(page);
	}

	@Override
	public boolean addNotice(Notice no) {
		int row=nomapper.addNotice(no);
		if(row>0)
			return true;
		
		return false;
	}

	@Override
	public boolean updateNotice(Notice no) {
		int row=nomapper.updateNotice(no);
		if(row>0)
			return true;
		
		return false;
	}

	@Override
	public boolean deleteNotice(int[] nid) {
		int row=nomapper.deleteNotice(nid);
		if(row>0)
			return true;
		
		return false;
	}

	
}
