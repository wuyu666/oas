package com.chinasofti.oas.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.oas.bean.Notice;
import com.chinasofti.oas.bean.Page;
import com.chinasofti.oas.service.INoticeService;
@Controller
@RequestMapping("/notice")
public class NoticeController {
	@Resource	
	private INoticeService noticeService;
	
	
	@RequestMapping("/doSelect")
	@ResponseBody
	public String doSelect(Page page){
	
	return null;
	}
}
