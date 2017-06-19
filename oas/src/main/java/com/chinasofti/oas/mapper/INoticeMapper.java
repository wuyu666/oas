package com.chinasofti.oas.mapper;

import java.util.List;
import java.util.Map;

import com.chinasofti.oas.bean.Notice;
import com.chinasofti.oas.bean.Page;

public interface INoticeMapper {
	public List<Notice> queryNotice(Map<String, Object> map);
	public long queryCount(Map<String, Object> map);;
	boolean add(Notice no);
	boolean update(Notice no);
	boolean delete(Integer nid);
}
