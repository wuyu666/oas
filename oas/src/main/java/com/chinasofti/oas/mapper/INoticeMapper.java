package com.chinasofti.oas.mapper;

import java.util.List;
import java.util.Map;

import com.chinasofti.oas.bean.Notice;
import com.chinasofti.oas.bean.Page;

public interface INoticeMapper {
	public List<Notice> queryNotice(Page <Notice> page);
	public int queryCount(Page <Notice> page);;
	public int addNotice(Notice no);
	public int updateNotice(Notice no);
	public int deleteNotice(int[] nid);
}
