package com.chinasofti.oas.service;

import java.util.Map;


import com.chinasofti.oas.bean.Notice;
import com.chinasofti.oas.bean.Page;

public interface INoticeService {
	public void queryNotice(Page<Notice> page);
	public int queryCount(Page<Notice> page);;
	public boolean addNotice(Notice no);
	public boolean updateNotice(Notice no);
	public boolean deleteNotice(int[] nid);
	
}
