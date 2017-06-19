package com.chinasofti.oas.mapper;

import java.util.List;
import java.util.Map;

import com.chinasofti.oas.bean.Notice;
import com.chinasofti.oas.bean.Page;

public interface INoticeMapper {
	public List<Notice> queryNotice(Map<String, Object> map);
	public int queryCount(Map<String, Object> map);;
	public int add(Notice no);
	public int update(Notice no);
	public int delete(Integer nid);
}
