package com.chinasofti.oas.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.oas.bean.Notice;
import com.chinasofti.oas.bean.Page;

import com.chinasofti.oas.service.INoticeService;


import com.chinasofti.oas.utils.Result;



@Controller
@RequestMapping("/notice")
public class NoticeController {
	@Resource
	private INoticeService noticeService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	/**
	 * 查询公告
	 * 
	 * @param page
	 * @param rows
	 * @param no
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryNotice")
	@ResponseBody
	public Page<Notice> queryNotice(Notice no, Integer curPage, Integer pageSize) {
		System.out.println("no=" + no);
		Page<Notice> page = new Page<Notice>();
		page.setQuery(no);
		if (curPage != null)
			page.setCurPage(curPage);
		if (pageSize != null)
			page.setPageSize(pageSize);

		noticeService.queryNotice(page);
		return page;
	}

	/**
	 * 添加公告
	 * 
	 * @param no
	 * @return
	 */
	@RequestMapping("/addNotice")
	@ResponseBody
	public Result addNotice(Notice no) {
		boolean flag = noticeService.addNotice(no);
		Result result = new Result();
		if (flag) {
			result.setStatus(1);
			result.setTip("添加成功");
		} else {
			result.setStatus(0);
			result.setTip("添加失败");
		}

		return result;
	}

	/**
	 * 修改公告
	 * @param no
	 * @return
	 */
	@RequestMapping("/updateNotice")
	@ResponseBody
	public Result updateNotice(Notice no) {
		System.out.println("修改" + no.toString());
		boolean flag = noticeService.updateNotice(no);
		Result result = new Result();
		if (flag) {
			result.setStatus(1);
			result.setTip("修改成功");
		} else {
			result.setStatus(0);
			result.setTip("修改失败");
		}

		return result;
	}

	/**
	 * 删除公告
	 * @param ids
	 * @return
	 */
	@RequestMapping("/deleteNotice")
	@ResponseBody
	public Result deleteNotice(int[] ids) {
		boolean flag = noticeService.deleteNotice(ids);
		Result result = new Result();
		if (flag) {
			result.setStatus(1);
			result.setTip("删除成功");
		} else {
			result.setStatus(0);
			result.setTip("删除失败");
		}
		return result;
	}
}
