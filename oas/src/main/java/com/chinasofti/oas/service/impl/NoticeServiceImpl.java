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
	private INoticeMapper nomapper;
	@Resource  
	    public void setNoMapper(INoticeMapper nomapper) {  
	        this.nomapper = nomapper;  
	    }  
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
		// TODO Auto-generated method stub
		return nomapper.add(no);
	}

	@Override
	public boolean update(Notice no) {
		// TODO Auto-generated method stub
		return nomapper.update(no);
	}

	@Override
	public boolean delete(Integer nid) {
		// TODO Auto-generated method stub
		return nomapper.delete(nid);
	}
	
}
