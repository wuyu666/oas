package com.chinasofti.oas.service;

import java.util.List;
import java.util.Map;

import com.chinasofti.oas.bean.Notice;

public interface INoticeService {
	public List<Notice> queryNotice(Map<String, Object> map);
	public long queryCount(Map<String, Object> map);;
	public int add(Notice no);
	public int update(Notice no);
	public int delete(Integer nid);
	
}
